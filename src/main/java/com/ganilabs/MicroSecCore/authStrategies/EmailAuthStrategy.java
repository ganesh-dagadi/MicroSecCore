package com.ganilabs.MicroSecCore.authStrategies;

import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandlerBuilder;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.AbstractHelperStrategy;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.OTPHelperStrategy;
import com.ganilabs.MicroSecCore.authStrategies.helperStrategies.PasswordHelperStrategy;

public class EmailAuthStrategy extends AbstractAuthStrategy {
    public EmailAuthStrategy(AuthenticationHandlerBuilder builder) {
        super(builder);
    }

    public AbstractHelperStrategy helperStrategy;

    @Override
    public AuthenticationHandlerBuilder withPassword() {
        this.helperStrategy = new PasswordHelperStrategy();
        return builder;
    }

    @Override
    public AuthenticationHandlerBuilder withOTP() {
        this.helperStrategy = new OTPHelperStrategy();
        return builder;
    }

    @Override
    public Boolean registerUser() {
        System.out.println("Registering user with email");
        helperStrategy.verify();
        return false;
    }


}
