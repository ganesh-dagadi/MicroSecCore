package com.ganilabs.MicroSecCore.authStrategies.helperStrategies;

public class PasswordHelperStrategy extends AbstractHelperStrategy {
    public Boolean verify(){
        System.out.println("verifying password");
        return true;
    }
}
