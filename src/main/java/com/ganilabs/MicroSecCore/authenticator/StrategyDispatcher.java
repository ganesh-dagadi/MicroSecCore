package com.ganilabs.MicroSecCore.authenticator;

import com.ganilabs.MicroSecCore.Exceptions.UnsupportedAuthenticationException;
import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandler;
import com.ganilabs.MicroSecCore.api.roles.RoleAuthChainMap;
import com.ganilabs.MicroSecCore.authStrategies.AbstractAuthStrategy;
import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;
import com.ganilabs.MicroSecCore.constants.RequestConstants;


import java.util.*;
import java.util.stream.Collectors;

//look at different strategies configured and dispatch the ones matching the request
public class StrategyDispatcher {
    public List<AbstractAuthStrategy> dispatchRegistrationStrategies(AuthenticationHandler handler, RoleAuthChainMap roleMap ,  AbstractParsedRequest request) throws UnsupportedAuthenticationException, IllegalArgumentException{
        String role = (String)request.getBody().get(RequestConstants.USERROLE.value);
        List<AuthenticationStrategyChain> availableChains = this.filterByRole(handler.getAuthStrategies() , roleMap , role);
        availableChains = this.filterByRequest(availableChains , request);
        if(availableChains.isEmpty()) throw new UnsupportedAuthenticationException("Requested Authentication Strategy not supported");
        // return a list of primary authentication strategies
        return availableChains.stream()
                .map(chain->chain.getChain().get(0))
                .collect(Collectors.toList());

    }

    //filters only based on first authentication strategy that has been configured in strategies list
    private List<AuthenticationStrategyChain> filterByRequest(List<AuthenticationStrategyChain> availableChains , AbstractParsedRequest request){
        List<AuthenticationStrategyChain> filteredChain = new ArrayList<>();
        for(AuthenticationStrategyChain chain : availableChains){
            if(chain.getChain().get(0).isStrategyApplicableForRequest(request)){
                filteredChain.add(chain);
            }
        }
        //if multiple types of base auth strategies are found eg email password and phone otp, choose
        return filteredChain;
    }

    private List<AuthenticationStrategyChain> filterByRole(List<AuthenticationStrategyChain> availableChains , RoleAuthChainMap roleMap , String role)throws IllegalArgumentException {
        if (roleMap == null) return availableChains;
        if (role == null) throw new IllegalArgumentException("Role must be specified");
        //no specific authStrategies configured for the role so pass all
        if (!roleMap.getRoleAuthMaps().containsKey(role)) return availableChains;
        List<AuthenticationStrategyChain> configuredRoleAuthChains = roleMap.getRoleAuthMaps().get(role);
        List<AuthenticationStrategyChain> returnableAuthChains = new ArrayList<>();
        Set<AuthenticationStrategyChain> added = new HashSet<>();
        for (AuthenticationStrategyChain chain : availableChains) {
            for (AuthenticationStrategyChain roleChain : configuredRoleAuthChains) {
                if (roleChain.equals(chain) && !added.contains(roleChain)) {
                    added.add(roleChain);
                    returnableAuthChains.add(roleChain);
                    break;
                }
            }
        }
        return returnableAuthChains;
    }
}
