package com.ganilabs.MicroSecCore.constants;

public enum RequestConstants {
    EMAIL("email"),
    PASSWORD("password"),
    OTP("otp"),
    PHONENUMBER("phoneNumber"),
    USERROLE("role");

    public final String value;
    RequestConstants(String value){

        this.value = value;
    }
}
