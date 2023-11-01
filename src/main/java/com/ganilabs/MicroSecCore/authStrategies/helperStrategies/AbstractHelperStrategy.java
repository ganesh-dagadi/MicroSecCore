package com.ganilabs.MicroSecCore.authStrategies.helperStrategies;


import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;

public abstract class AbstractHelperStrategy {
    public abstract Boolean verify();
    public abstract Boolean isStrategyApplicableForRequest(AbstractParsedRequest request);
}
