package com.ganilabs.MicroSecCore.api.authenticationHandler;

import com.ganilabs.MicroSecCore.api.roles.RoleAuthChainMap;

public interface MicroSecConfig {
    public AuthenticationHandler getAuthenticationStrategy();
    public RoleAuthChainMap configureRoleAuthChains();
}
