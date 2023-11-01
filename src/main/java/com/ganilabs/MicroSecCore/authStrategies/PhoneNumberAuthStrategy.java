package com.ganilabs.MicroSecCore.authStrategies;


import com.ganilabs.MicroSecCore.api.AuthenticationChainBuilder;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandlerBuilder;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.AbstractHelperStrategy;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.OTPHelperStrategy;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.PasswordHelperStrategy;
import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;
import com.ganilabs.MicroSecCore.constants.RequestConstants;

import java.util.Map;

public class PhoneNumberAuthStrategy extends AbstractAuthStrategy{
    public PhoneNumberAuthStrategy(AuthenticationChainBuilder builder) {
        super(builder);
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
        throw new IllegalArgumentException("Phone Number needs verification");
    }

    @Override
    public Boolean isStrategyApplicableForRequest(AbstractParsedRequest request) {
        Map<String, Object> body = request.getBody();
        return body.containsKey(RequestConstants.PHONENUMBER.toString()) && this.helperStrategy.isStrategyApplicableForRequest(request);
    }

    @Override
    public Boolean registerUser(){
        System.out.println("Registering user with phone number");
        helperStrategy.verify();
        return true;
    }
}
