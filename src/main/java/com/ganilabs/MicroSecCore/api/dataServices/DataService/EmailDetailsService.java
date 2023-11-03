package com.ganilabs.MicroSecCore.api.dataServices.DataService;

import com.ganilabs.MicroSecCore.api.dataServices.UserData.AbstractUserData;

public interface EmailDetailsService {
    public AbstractUserData getUserByEmail(String email);
}
