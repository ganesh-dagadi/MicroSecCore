package com.ganilabstest.MicroSec.test.api.authenticator;

import com.ganilabs.MicroSecCore.MicroSec;
import com.ganilabs.MicroSecCore.api.AuthenticationChainBuilder;
import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandler;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandlerBuilder;
import com.ganilabs.MicroSecCore.authStrategies.AbstractAuthStrategy;
import com.ganilabs.MicroSecCore.authenticator.StrategyDispatcher;
import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;
import com.ganilabstest.MicroSec.test.api.Configurations.MicroSecBeanMain;
import com.ganilabstest.MicroSec.test.api.Configurations.MicroSecConfiguration;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class StrategyDispatcherTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(MicroSecBeanMain.class);
    @Test
    public void getEmailStrategyForEmailPasswordUserRegistrationNoRoleConfig(){
      StrategyDispatcher dispatcher = new StrategyDispatcher();
        AuthenticationHandler authStrategies = AuthenticationHandlerBuilder.getBuilder().initBuilder()
                .insertChain(AuthenticationChainBuilder.getBuilder().initBuilder().withEmail().withPassword().
                        and().build())
                .build();

        AbstractParsedRequest request = Mockito.mock(AbstractParsedRequest.class);
        Map<String , Object> simpleRequestBody = new HashMap<>();
        simpleRequestBody.put("email" , "ganeshdagadi3@gmail.com");
        simpleRequestBody.put("password" , "pass123");
        simpleRequestBody.put("role" , "USER");
        when(request.getBody()).thenReturn(simpleRequestBody);
        try{
            List<AbstractAuthStrategy> returned = dispatcher.dispatchRegistrationStrategies(authStrategies , null , request);
            List<AbstractAuthStrategy> expected =  List.of(authStrategies.getAuthStrategies().get(0).getChain().get(0));
            assertEquals(expected, returned);
        }catch(Exception e) {
            System.out.println("failed dispatching email auth");
            fail();
        }
    }

    @Test
    public void getEmailPasswordOrPhoneOTPStrategiesForUserRegistration(){
        StrategyDispatcher dispatcher = new StrategyDispatcher();
        MicroSecConfiguration configuration = new MicroSecConfiguration();
        AbstractParsedRequest request = Mockito.mock(AbstractParsedRequest.class);
        Map<String , Object> simpleRequestBody = new HashMap<>();
        simpleRequestBody.put("email" , "ganeshdagadi3@gmail.com");
        simpleRequestBody.put("password" , "pass123");
        simpleRequestBody.put("phoneNumber" , "12345");
        simpleRequestBody.put("otp" , "234");
        simpleRequestBody.put("role" , "USER");
        when(request.getBody()).thenReturn(simpleRequestBody);
        List<AbstractAuthStrategy> expected = new ArrayList<>();
        //adding email password
        expected.add(configuration.getAuthenticationStrategy().getAuthStrategies().get(0).getChain().get(0));
        //add phone otp
        expected.add(configuration.getAuthenticationStrategy().getAuthStrategies().get(1).getChain().get(0));
        try{
            List<AbstractAuthStrategy> returned = dispatcher.dispatchRegistrationStrategies(
                    configuration.getAuthenticationStrategy(),
                    configuration.configureRoleAuthChains(),
                    request
            );
            assertEquals(expected , returned);
        }catch(Exception e){
            fail();
        }

    }

}
