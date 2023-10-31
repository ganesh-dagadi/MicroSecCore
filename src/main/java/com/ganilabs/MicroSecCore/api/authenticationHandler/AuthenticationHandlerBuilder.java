package com.ganilabs.MicroSecCore.api.authenticationHandler;

import com.ganilabs.MicroSecCore.authStrategies.AbstractAuthStrategy;
import com.ganilabs.MicroSecCore.authStrategies.EmailAuthStrategy;
import com.ganilabs.MicroSecCore.authStrategies.PhoneNumberAuthStrategy;

public class AuthenticationHandlerBuilder {
    private AuthenticationHandler authHandler;
    private AuthenticationStrategyChain currChain;
    private AbstractAuthStrategy currStrategy;

    public static AuthenticationHandlerBuilder getBuilder() {
        return new AuthenticationHandlerBuilder();
    }

    public AuthenticationHandlerBuilder initBuilder() {
        authHandler = new AuthenticationHandler();
        this.currChain = new AuthenticationStrategyChain();
        return this;
    }

    public AbstractAuthStrategy withEmail() {
        AbstractAuthStrategy strategy = new EmailAuthStrategy(this);
        this.currStrategy = strategy;
        return strategy;
    }

    public AbstractAuthStrategy withPhone() {
        AbstractAuthStrategy strategy = new PhoneNumberAuthStrategy(this);
        this.currStrategy = strategy;
        return strategy;
    }

    public AuthenticationHandlerBuilder and(){
        this.currChain.addStrategy(currStrategy);
        return this;
    }

    public AuthenticationHandlerBuilder or() {
        this.currChain.addStrategy(currStrategy);
        this.authHandler.addAuthStrategyChain(currChain);
        this.currChain = new AuthenticationStrategyChain();
        return this;
    }

    public AuthenticationHandlerBuilder none(){
        return this;
    }

    public AuthenticationHandler build() {
        return this.authHandler;
    }

}