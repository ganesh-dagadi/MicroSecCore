package com.ganilabs.MicroSecCore.authStrategies;

import com.ganilabs.MicroSecCore.api.AuthenticationChainBuilder;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandlerBuilder;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.OTPHelperStrategy;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.PasswordHelperStrategy;
import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;

public abstract class AbstractAuthStrategy {
    protected AuthenticationChainBuilder builder;

    protected AbstractAuthStrategy(AuthenticationChainBuilder builder){
        this.builder = builder;

    }

    public abstract AuthenticationChainBuilder withPassword();

    public abstract AuthenticationChainBuilder withOTP();

    public abstract AuthenticationChainBuilder withNone() throws IllegalArgumentException;

    public abstract Boolean isStrategyApplicableForRequest(AbstractParsedRequest request);

    public abstract Boolean registerUser();
}
