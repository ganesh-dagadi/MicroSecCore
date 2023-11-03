package com.ganilabs.MicroSecCore.authStrategies;

import com.ganilabs.MicroSecCore.api.AuthenticationChainBuilder;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandlerBuilder;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.AbstractHelperStrategy;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.OTPHelperStrategy;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.PasswordHelperStrategy;
import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;
import com.ganilabs.MicroSecCore.constants.RequestConstants;

public class EmailAuthStrategy extends AbstractAuthStrategy {
    public EmailAuthStrategy(AuthenticationChainBuilder builder) {
        super(builder);
    }

    @Override
    public Boolean isStrategyApplicableForRequest(AbstractParsedRequest request) {
        return request.getBody().containsKey(RequestConstants.EMAIL.value) && helperStrategy.isStrategyApplicableForRequest(request);
    }

    public AbstractHelperStrategy helperStrategy;

    @Override
    public AuthenticationChainBuilder withPassword() {
        this.helperStrategy = new PasswordHelperStrategy();
        return builder;
    }
    @Override
    public AuthenticationChainBuilder withOTP() {
        this.helperStrategy = new OTPHelperStrategy();
        return builder;
    }

    @Override
    public AuthenticationChainBuilder withNone() throws IllegalArgumentException{
        throw new IllegalArgumentException("Email needs verification");
    }

    @Override
    public Boolean registerUser() {
        System.out.println("Registering user with email");
        helperStrategy.verify();
        return false;
    }


}
