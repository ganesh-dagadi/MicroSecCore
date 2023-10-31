package com.ganilabs.MicroSecCore.authenticator.parser;

import jakarta.servlet.http.HttpServletRequest;

public interface RequestParser {
    public AbstractParsedRequest parseRequest(HttpServletRequest request);
}
