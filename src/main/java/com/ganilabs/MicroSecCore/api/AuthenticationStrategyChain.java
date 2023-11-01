package com.ganilabs.MicroSecCore.api;
import com.ganilabs.MicroSecCore.authStrategies.AbstractAuthStrategy;

import java.util.ArrayList;
import java.util.List;


public class AuthenticationStrategyChain {
    private final List<AbstractAuthStrategy> chain;
    public AuthenticationStrategyChain(){
        this.chain = new ArrayList<>();
    }
    public void addStrategy(AbstractAuthStrategy strategy){
        this.chain.add(strategy);
    }
    public List<AbstractAuthStrategy> getChain(){
        return chain;
    }
}
