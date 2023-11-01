package com.ganilabs.MicroSecCore.api.roles;

import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;

import java.util.HashMap;
import java.util.Map;

public class RoleAuthChainMap {
    Map<String , AuthenticationStrategyChain> map = new HashMap<>();
    public void addRule(String role , AuthenticationStrategyChain chain){
        this.map.put(role , chain);
    }

    public Map<String , AuthenticationStrategyChain> getRoleAuthMaps(){
        return this.map;
    }

}
