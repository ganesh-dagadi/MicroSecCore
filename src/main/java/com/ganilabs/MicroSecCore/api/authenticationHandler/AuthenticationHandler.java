package com.ganilabs.MicroSecCore.api.authenticationHandler;

import com.ganilabs.MicroSecCore.authStrategies.AbstractAuthStrategy;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationHandler {
    private final List<AuthenticationStrategyChain> authHandlers = new ArrayList<>();
    public void addAuthStrategyChain(AuthenticationStrategyChain chain){
        this.authHandlers.add(chain);
    }

    public void registerUser(){
        for(AuthenticationStrategyChain chain : authHandlers){
            for(AbstractAuthStrategy authStrategy : chain.getChain()){
                if(authStrategy.registerUser()) return;
            }
        }
    }
}