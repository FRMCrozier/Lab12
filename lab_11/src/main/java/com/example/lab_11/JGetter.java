package com.example.lab_11;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Класс загрузки апи
 */
@UtilityClass
public class JGetter {
    /**
     * Метод загрузки апи
     */
    public static Wows loadByURL(String url) throws IOException { //NOPMD - suppressed MethodArgumentCouldBeFinal - this value is final in other method
        StringBuilder jsonIn = new StringBuilder(); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        InputStream inputs = new URL(url).openStream(); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        try { //NOPMD - suppressed UseTryWithResources - resources are under control
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputs, StandardCharsets.UTF_8)); //NOPMD - suppressed CloseResource - resource was closed in the end of this method
            int count;
            while ((count = rd.read()) != -1) { //NOPMD - suppressed AssignmentInOperand - this operand is needed
                jsonIn.append((char) count);
            }
            rd.close();
        } finally {
            inputs.close();
        }
        ObjectMapper objectMapper = new ObjectMapper(); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        List<Wow> wows = objectMapper.readValue(jsonIn.toString().strip(), objectMapper.getTypeFactory().constructCollectionType(List.class, Wow.class)); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        Wows wows1 = new Wows(); //NOPMD - suppressed LocalVariableCouldBeFinal - no final needed
        wows1.setResults(wows);

        return wows1;

    }
}