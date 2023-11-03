package com.ganilabs.MicroSecCore.api.dataServices.DataService;

import com.ganilabs.MicroSecCore.api.dataServices.UserData.AbstractUserData;

import java.util.UUID;

public interface UserDetailsService {
    public AbstractUserData getUserData(UUID user_id);

    public void saveUserData(AbstractUserData userData);
}
