package com.ganilabs.MicroSecCore.authStrategies.helperStrategies;

import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;
import com.ganilabs.MicroSecCore.constants.RequestConstants;

public class OTPHelperStrategy extends AbstractHelperStrategy{
    public Boolean verify(){
        System.out.println("verifying otp");
        return true;
    }

    @Override
    public Boolean isStrategyApplicableForRequest(AbstractParsedRequest request) {
        return request.getBody().containsKey(RequestConstants.OTP.value);
    }
}
