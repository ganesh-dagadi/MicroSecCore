package com.ganilabs.MicroSecCore.api.authenticationHandler;

import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandler;

public interface UserIdentificationService {
    public AuthenticationHandler getAuthenticationStrategy();
}
