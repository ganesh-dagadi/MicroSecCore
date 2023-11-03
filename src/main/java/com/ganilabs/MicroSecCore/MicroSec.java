package com.ganilabs.MicroSecCore;

import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandler;
import com.ganilabs.MicroSecCore.api.authenticationHandler.MicroSecConfig;
import com.ganilabs.MicroSecCore.authenticator.StrategyDispatcher;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MicroSec {
    @Autowired
    AuthenticationHandler authHandler;

}
