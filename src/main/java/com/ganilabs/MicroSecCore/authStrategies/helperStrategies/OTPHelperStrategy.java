package com.ganilabs.MicroSecCore.authStrategies.helperStrategies;

public class OTPHelperStrategy extends AbstractHelperStrategy{
    public Boolean verify(){
        System.out.println("verifying otp");
        return true;
    }
}
