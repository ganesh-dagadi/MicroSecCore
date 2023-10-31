package com.ganilabs.MicroSecCore.authenticator.parser;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

public class JSONParsedRequest extends AbstractParsedRequest{
    JSONParsedRequest(HttpServletRequest request) {
        super(request);
    }
    private Map<String , Object> body;
    @Override
    public Map<String , Object> getBody() {
        return this.body;
    }

    @Override
    public void setBody(Map<String, Object> body){
        this.body = body;
    }

}
