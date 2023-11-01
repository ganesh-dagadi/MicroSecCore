package com.ganilabs.MicroSecCore.api;

import com.ganilabs.MicroSecCore.authStrategies.AbstractAuthStrategy;
import com.ganilabs.MicroSecCore.authStrategies.EmailAuthStrategy;
import com.ganilabs.MicroSecCore.authStrategies.PhoneNumberAuthStrategy;

public class AuthenticationChainBuilder {

    AuthenticationStrategyChain currChain;
    AbstractAuthStrategy currStrategy;
    public static AuthenticationChainBuilder getBuilder(){
        return new AuthenticationChainBuilder();
    }

    public AuthenticationChainBuilder initBuilder(){
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

    public AuthenticationChainBuilder and(){
        this.currChain.addStrategy(currStrategy);
        return this;
    }
    public AuthenticationStrategyChain build(){
        return this.currChain;
    }


}
