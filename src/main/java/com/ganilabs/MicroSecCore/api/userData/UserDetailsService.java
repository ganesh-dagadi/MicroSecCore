package com.ganilabs.MicroSecCore.api.userData;

import com.ganilabs.MicroSecCore.api.userData.AbstractUserData;

import java.util.UUID;

public interface UserDetailsService {
    public AbstractUserData getUserData(UUID user_id);

    public void saveUserData(AbstractUserData userData);
}
