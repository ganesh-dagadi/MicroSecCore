package com.ganilabs.MicroSecCore.api.dataServices.UserData;

import java.util.List;
import java.util.UUID;

public abstract class AbstractUserData {
    private UUID userid;
    private Boolean isEnabled;
    private Boolean isVerified;

    public  UUID getUserId(){
        return this.userid;
    }
    public  void setUserId(UUID userId){
        this.userid = userId;
    }

    public abstract Boolean getEnabled();
    public abstract void setEnabled(Boolean isEnabled);

    public abstract Boolean getVerified();
    public abstract void setVerified(Boolean isEnabled);
    public abstract List<String> getRoles();
    public abstract void setRoles(List<String> roles);

}