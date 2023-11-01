package com.ganilabs.MicroSecCore.api.authenticationHandler;

import com.ganilabs.MicroSecCore.api.AuthenticationChainBuilder;
import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;
import com.ganilabs.MicroSecCore.authStrategies.AbstractAuthStrategy;
import com.ganilabs.MicroSecCore.authStrategies.EmailAuthStrategy;
import com.ganilabs.MicroSecCore.authStrategies.PhoneNumberAuthStrategy;

public class AuthenticationHandlerBuilder {
    private AuthenticationHandler authHandler;

    public static AuthenticationHandlerBuilder getBuilder() {
        return new AuthenticationHandlerBuilder();
    }

    public AuthenticationHandlerBuilder initBuilder() {
        authHandler = new AuthenticationHandler();
        return this;
    }

    public AuthenticationHandlerBuilder insertChain(AuthenticationStrategyChain chain) {
        this.authHandler.addAuthStrategyChain(chain);
        return this;
    }

    public AuthenticationHandler build() {
        return this.authHandler;
    }

}