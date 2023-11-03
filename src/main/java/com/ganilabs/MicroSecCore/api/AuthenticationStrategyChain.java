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
    public Boolean equals(AuthenticationStrategyChain chain2){
        List<AbstractAuthStrategy> thisChain = this.chain;
        List<AbstractAuthStrategy> otherChain = chain2.getChain();
        for(int i = 0 ; i < thisChain.size() ; i++){
            if(thisChain.get(i).getClass() != otherChain.get(i).getClass()) return false;
        }
        return true;
    }
}
