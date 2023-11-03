package com.ganilabstest.MicroSec.test.api.Configurations;

import com.ganilabs.MicroSecCore.api.AuthenticationChainBuilder;
import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandler;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandlerBuilder;
import com.ganilabs.MicroSecCore.api.authenticationHandler.MicroSecConfig;
import com.ganilabs.MicroSecCore.api.roles.RoleAuthChainMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MicroSecConfiguration implements MicroSecConfig {
    @Override
    @Bean
    public AuthenticationHandler getAuthenticationStrategy() {
        return AuthenticationHandlerBuilder.getBuilder().initBuilder()
                .insertChain(AuthenticationChainBuilder.getBuilder().initBuilder().withEmail().withPassword().and().build())
                .insertChain(AuthenticationChainBuilder.getBuilder().initBuilder().withPhone().withOTP().and().build())
                .insertChain(AuthenticationChainBuilder.getBuilder().initBuilder().
                        withEmail().withPassword().and().withPhone().withOTP().and().build()
                )
                .build();
    }

    @Override
    public RoleAuthChainMap configureRoleAuthChains() {
        RoleAuthChainMap roleAuthMap = new RoleAuthChainMap();
        List<AuthenticationStrategyChain> userRules = new ArrayList<>();
        AuthenticationStrategyChain emailPassword = AuthenticationChainBuilder
                .getBuilder().initBuilder().withEmail().withPassword().and().build();
        AuthenticationStrategyChain phoneOTP = AuthenticationChainBuilder.getBuilder().initBuilder()
                .withPhone().withOTP().and().build();
        userRules.add(emailPassword);
        userRules.add(phoneOTP);
        roleAuthMap.addRule("USER", userRules);
        List<AuthenticationStrategyChain> adminRules = new ArrayList<>();
        AuthenticationStrategyChain emailPasswordPhoneOTPMFA = AuthenticationChainBuilder.getBuilder().initBuilder()
                .withEmail().withPassword().and().withPhone().withOTP().and().build();
        adminRules.add(emailPasswordPhoneOTPMFA);
        roleAuthMap.addRule("ADMIN", adminRules);
        return roleAuthMap;
    }
}
