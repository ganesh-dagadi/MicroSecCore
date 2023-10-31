package com.ganilabs.MicroSecCore.authenticator.parser;

import com.ganilabs.MicroSecCore.Exceptions.InvalidContentTypeException;
import jakarta.servlet.http.HttpServletRequest;

public class ParsingChooser {
    public static RequestParser chooseParser(HttpServletRequest request) throws InvalidContentTypeException{
        if(request.getContentType().equals("application/json")) return new JSONParser();
        else throw new InvalidContentTypeException();
    }
}
