package com.ganilabs.MicroSecCore.authenticator;

import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandler;
import com.ganilabs.MicroSecCore.api.AuthenticationStrategyChain;
import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//look at different strategies configured and dispatch the ones matching the request
public class StrategyDispatcher {
    @Autowired
    AuthenticationHandler authHandler;

}
