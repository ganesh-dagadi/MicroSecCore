package com.ganilabs.MicroSecCore.authenticator.parser;

import jakarta.servlet.http.HttpServletRequest;

import java.net.http.HttpHeaders;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractParsedRequest {
    // abstract methods must be implemented by specific parsing strategies
    private HttpServletRequest request;
    private Map<String , List<String>> headers;
    AbstractParsedRequest(HttpServletRequest request){
        this.request = request;
        Map<String, List<String>> headersMap = Collections.list(request.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        h -> Collections.list(request.getHeaders(h))
                ));
        this.headers = headersMap;
    }
    public abstract Map<String , Object> getBody();
    public abstract void setBody(Map<String, Object> body);
    public  Map<String , List<String>> getHeaders(){
        return this.headers;
    }
}
