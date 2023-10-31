package com.ganilabs.MicroSecCore.authenticator;


import com.ganilabs.MicroSecCore.Exceptions.InvalidContentTypeException;
import com.ganilabs.MicroSecCore.authenticator.parser.AbstractParsedRequest;
import com.ganilabs.MicroSecCore.authenticator.parser.ParsingChooser;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;

public class Authenticator {
    public static void handleRegister(HttpServletRequest request) throws InvalidContentTypeException {
        AbstractParsedRequest parsedRequest= ParsingChooser.chooseParser(request).parseRequest(request);
    }
}
