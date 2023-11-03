package com.ganilabs.MicroSecCore.api.dataServices.DataService;

import com.ganilabs.MicroSecCore.api.dataServices.UserData.AbstractUserData;

public interface PhoneNumberDetailsService {
    public AbstractUserData getUserWithPhoneNumber(String phoneNumber);
}
