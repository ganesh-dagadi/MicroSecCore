package com.ganilabs.MicroSecCore.api.authenticationHandler;

import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationHandler {
    private final List<AuthenticationStrategyChain> authStrategies = new ArrayList<>();
    public void addAuthStrategyChain(AuthenticationStrategyChain chain){
        this.authStrategies.add(chain);
    }
    public List<AuthenticationStrategyChain> getAuthStrategies(){
        return this.authStrategies;
    };

}