package com.ganilabs.MicroSecCore.authenticator.parser;

import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static javax.print.attribute.standard.ReferenceUriSchemesSupported.HTTP;

public class JSONParser implements RequestParser{


    @Override
    public AbstractParsedRequest parseRequest(HttpServletRequest request) {
        StringBuffer jsonBuff = new StringBuffer();
        String line = null;
        try{
            BufferedReader reader = request.getReader();
            while((line = reader.readLine())!= null){
                jsonBuff.append(line);
            }
        }catch (IOException e){
            System.out.println(e.toString());
        }
        Map<String , Object> body = new HashMap<>();
        String temp = jsonBuff.toString();
        //System.out.println(temp.length());
        JSONObject jsonObject = new JSONObject(temp);
        Iterator<String> itr = jsonObject.keys();
        while(itr.hasNext()){
            String key = itr.next();
            body.put(key , jsonObject.get(key));
        }
        AbstractParsedRequest toReturn = new JSONParsedRequest(request);
        toReturn.setBody(body);
        return toReturn;
    }
}
