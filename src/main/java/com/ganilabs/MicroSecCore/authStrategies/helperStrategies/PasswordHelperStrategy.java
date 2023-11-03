package com.ganilabs.MicroSecCore.authStrategies.helperStrategies;

import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;
import com.ganilabs.MicroSecCore.constants.RequestConstants;

public class PasswordHelperStrategy extends AbstractHelperStrategy {
    public Boolean verify(){
        System.out.println("verifying password");
        return true;
    }

    @Override
    public Boolean isStrategyApplicableForRequest(AbstractParsedRequest request) {
        return request.getBody().containsKey(RequestConstants.PASSWORD.value);
    }
}
