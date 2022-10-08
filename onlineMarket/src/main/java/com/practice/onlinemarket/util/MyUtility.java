package com.practice.onlinemarket.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
@Component
@Slf4j
public class MyUtility {

    /**
     * Helper method which used to change object to Json
     * @param object
     * @return string of abject
     * @throws JsonProcessingException
     */
    public String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    /**
     * Tokenization method for input file
     * @param input
     * @return
     */
    public static SecretKey generateKey(String input) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(input);
            return keyGenerator.generateKey();
        } catch (Exception exception) {
            return null;
        }
    }

    /**
     * Encrypt the input string
     * @param dataEncrypt
     * @param myKey
     * @param cipher
     * @return
     */
    public static byte[] encryptString(String dataEncrypt, SecretKey myKey, Cipher cipher) {
        try {
            byte [] text= dataEncrypt.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE,myKey);
            return cipher.doFinal(text);
        } catch (Exception exception) {
            return new byte[0];
        }
    }

    /**
     * This method is used to decrypt the data
     * @param dataDecrypt
     * @param myKey
     * @param cipher
     * @return
     */
    public static String decryptString(byte [] dataDecrypt, SecretKey myKey, Cipher cipher) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE,myKey);
            byte [] textDecrypted = cipher.doFinal(dataDecrypt);
            return new String(textDecrypted);
        } catch (Exception exception) {
            return null;
        }

    }
}
