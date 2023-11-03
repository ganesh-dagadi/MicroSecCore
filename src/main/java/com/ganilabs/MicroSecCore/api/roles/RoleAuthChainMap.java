package com.ganilabs.MicroSecCore.api.roles;

import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleAuthChainMap {
    Map<String , List<AuthenticationStrategyChain>> map = new HashMap<>();
    public void addRule(String role , List<AuthenticationStrategyChain> chain){
        this.map.put(role , chain);
    }

    public Map<String , List<AuthenticationStrategyChain>> getRoleAuthMaps(){
        return this.map;
    }

}
