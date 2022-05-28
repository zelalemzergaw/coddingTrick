package com.practice.onlinemarket;

import com.practice.onlinemarket.util.Utility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class OnlineMarketApplication {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        SpringApplication.run(OnlineMarketApplication.class, args);
        SecretKey secretKey= Utility.generateKey("AES");
        Cipher chiper = Cipher.getInstance("AES");

        String str ="Hello my encryptor";
            try{
                byte [] encryptDta=  Utility.encryptString(str,secretKey,chiper);
                String stringEnc =new String(encryptDta);
                System.out.println("############ : " + stringEnc);
                String stringEDecry =Utility.decryptString(encryptDta,secretKey,chiper);
                System.out.println("************ : " + stringEDecry);
            }catch(Exception exception){

            }


    }

}
