package com.ganilabstest.MicroSec.test.api.authenticator;

import com.ganilabs.MicroSecCore.authenticator.parser.JSONParser;
import com.ganilabs.MicroSecCore.authenticator.parser.ParsingChooser;
import com.ganilabs.MicroSecCore.authenticator.parser.RequestParser;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class Authenticator {
    @Test
    public void testChoosingJSONParserByContentType(){
        HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
        when(mockedRequest.getContentType()).thenReturn("application/json");
        try{
            assertTrue( ParsingChooser.chooseParser(mockedRequest) instanceof JSONParser);
        }catch(Exception e){
            fail("Content type error");
        }

    }

    @Test
    public void testParsingJSONRequestBody() throws IOException {
        HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
        String test = "{\"foo\": \"bar\", \"foo2\": \"bar2\"}";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        when(mockedRequest.getContentType()).thenReturn("application/json");
        when(mockedRequest.getReader()).thenReturn(reader);
        Map<String, List<String>> headersMap = new HashMap<>();
        headersMap.put("Header1", Arrays.asList("Value1", "Value2"));
        headersMap.put("Header2", List.of("Value2"));

// Define the behavior of the mock
        when(mockedRequest.getHeaderNames()).thenReturn(Collections.enumeration(headersMap.keySet()));

        for (String headerName : headersMap.keySet()) {
            when(mockedRequest.getHeaders(headerName)).thenReturn(Collections.enumeration(headersMap.get(headerName)));
        }
        Map<String , Object> body = new HashMap<>();
        body.put("foo" , "bar");
        body.put("foo2" , "bar2");
        RequestParser parser = new JSONParser();
        assertEquals(body , parser.parseRequest(mockedRequest).getBody());
    }

    @Test
    public void testParsingHeadersWithJSONRequest() throws IOException{
        HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
        String test = "{\"foo\": \"bar\", \"foo2\": \"bar2\"}";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        when(mockedRequest.getContentType()).thenReturn("application/json");
        when(mockedRequest.getReader()).thenReturn(reader);
        Map<String, List<String>> headersMap = new HashMap<>();
        headersMap.put("Header1", Arrays.asList("Value1", "Value2"));
        headersMap.put("Header2", List.of("Value2"));

// Define the behavior of the mock
        when(mockedRequest.getHeaderNames()).thenReturn(Collections.enumeration(headersMap.keySet()));

        for (String headerName : headersMap.keySet()) {
            when(mockedRequest.getHeaders(headerName)).thenReturn(Collections.enumeration(headersMap.get(headerName)));
        }
        Map<String , Object> body = new HashMap<>();
        body.put("foo" , "bar");
        body.put("foo2" , "bar2");
        RequestParser parser = new JSONParser();
        assertEquals( headersMap , parser.parseRequest(mockedRequest).getHeaders());
    }
}
