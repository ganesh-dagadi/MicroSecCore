package com.ganilabstest.MicroSec.test.api;

import com.ganilabs.MicroSecCore.api.AuthenticationChainBuilder;
import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;
import com.ganilabs.MicroSecCore.authStrategies.AbstractAuthStrategy;
import com.ganilabs.MicroSecCore.authStrategies.EmailAuthStrategy;
import com.ganilabs.MicroSecCore.authStrategies.PhoneNumberAuthStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticationChainBuilderTest {
    @Test
    public void buildOnlyEmailPasswordAuthChain(){
        AuthenticationStrategyChain chain = new AuthenticationChainBuilder().initBuilder().
                withEmail().withPassword().and().build();
        AuthenticationStrategyChain expected = new AuthenticationStrategyChain();
        AbstractAuthStrategy email = new EmailAuthStrategy(new AuthenticationChainBuilder());
        email.withPassword();
        expected.addStrategy(email);
        assertTrue(chain.equals(expected));
    }

    @Test
    public void buildEmailPasswordPhoneOTPMFA(){
        AuthenticationStrategyChain chain = AuthenticationChainBuilder.getBuilder().initBuilder()
                .withEmail().withPassword().and().withPhone().withOTP().and().build();
        AuthenticationStrategyChain expected = new AuthenticationStrategyChain();
        AbstractAuthStrategy emailPassword = new EmailAuthStrategy(null);
        emailPassword.withPassword();
        expected.addStrategy(emailPassword);
        AbstractAuthStrategy phoneOTP = new PhoneNumberAuthStrategy(null);
        phoneOTP.withOTP();
        expected.addStrategy(phoneOTP);
        assertTrue(chain.equals(expected));
    }

    @Test
    public void failEmailPasswordPhoneOTPMFAStrategiesOutOfOrder(){
        AuthenticationStrategyChain chain = AuthenticationChainBuilder.getBuilder().initBuilder()
                .withEmail().withPassword().and().withPhone().withOTP().and().build();
        AuthenticationStrategyChain expected = new AuthenticationStrategyChain();
        AbstractAuthStrategy phoneOTP = new PhoneNumberAuthStrategy(null);
        phoneOTP.withOTP();
        expected.addStrategy(phoneOTP);
        AbstractAuthStrategy emailPassword = new EmailAuthStrategy(null);
        emailPassword.withPassword();
        expected.addStrategy(emailPassword);
        assertFalse(chain.equals(expected));
    }
}
