package com.practice.onlinemarket.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility {
    /**
     * Helper method which used to change object to Json
     * @param object
     * @return string of abject
     * @throws JsonProcessingException
     */
   public String mapToJson(Object object) throws JsonProcessingException {
       ObjectMapper objectMapper= new ObjectMapper();
       return objectMapper.writeValueAsString(object);
   }
}
