package com.ganilabstest.MicroSec.test.api;

import com.ganilabs.MicroSecCore.api.AuthenticationChainBuilder;
import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;
import com.ganilabs.MicroSecCore.authStrategies.EmailAuthStrategy;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthenticationStrategyChainTest {
    @Test
    public void verifyChainEqualsItself(){
        AuthenticationStrategyChain chain = AuthenticationChainBuilder.getBuilder().initBuilder()
                        .withEmail().withPassword().and().build();
        assertTrue(chain.equals(chain));
    }
    @Test
    public void verifyChainDoesNotEqualDifferentChain(){
        AuthenticationStrategyChain chain1 = AuthenticationChainBuilder.getBuilder().initBuilder()
                .withPhone().withPassword().and().build();
        AuthenticationStrategyChain chain2 = AuthenticationChainBuilder.getBuilder().initBuilder()
                .withEmail().withOTP().and().build();
        assertFalse(chain1.equals(chain2));
    }
}
