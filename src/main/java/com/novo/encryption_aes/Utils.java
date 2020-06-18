/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novo.encryption_aes;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



/**
 *
 * @author lmirabal
 */
public class Utils {
    
//    private static Logger log;
//    private static ObjectMapper mapper = new ObjectMapper();
//    private static Gson gson = new Gson();
    private static javax.naming.Context ctx;
    private static String lookup;

    public Utils() {
    }
    
    
    
       /**
     * Metodo AES para encriptar con una llave dinamica y un vector estatico
     * 
     * @param request
     * @param header
     * @return 
     * @throws java.lang.Exception 
     */
    public static ResponseTO decrypt(String request, String key) throws Exception {
        
        byte[] encodedKey;
        byte[] byteDecryptedText;
        String strDecryptedText;
        ResponseTO response = new ResponseTO();

        try {
            
            EncryptAESPojo encryptPojo = new EncryptAESPojo();
            encryptPojo.setKey(key.substring(5, 21));
            encryptPojo.setGeneratedText(request);

            encodedKey = Base64.decodeBase64(encryptPojo.getKey());
            SecretKeySpec skeySpec = new SecretKeySpec(encryptPojo.getKey().getBytes(), "AES"); // llave subministrada
            Cipher aesCipherForDecryption = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            aesCipherForDecryption.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec("X6QA0P13-98Z0-00".getBytes()));
            byteDecryptedText = aesCipherForDecryption.doFinal(Base64.decodeBase64(encryptPojo.getGeneratedText().getBytes()));
            strDecryptedText = new String(byteDecryptedText, "UTF-8");

            response.setRc("0");
            response.setBean(strDecryptedText);
            System.out.println("el bean seteado es: " + strDecryptedText);


        } 
        catch (javax.crypto.BadPaddingException ex2) {
                        
                response.setRc("-2005");
                response.setMsg("Error desencriptando");
                System.out.println(response.getMsg());
                System.out.println("Error: "+ ex2);         
        }
    
        catch (Exception ex) {
            try {                
                response.setRc("-1");
               System.out.println(response.getMsg());
                System.out.println("Error: "+ ex);
            } catch (Exception ex1) {
                response.setRc("-2005");
                response.setMsg("Error desencriptando");
            }
        } finally {
            System.out.println("*** Finaliza decrypt ***");
        }
        return response;
    }

    /**
     * Metodo de encriptado AES con una llave dinamica y un vector estatico
     * 
     * @param strDataToEncrypt
     * @param llave
     * @return 
     */
    public static ResponseTO encrypt(String strDataToEncrypt, String llave) {
 
        
        System.out.println("*** Inicia encrypt*****");

        llave = llave.substring(5, 21);
        ResponseTO response = new ResponseTO();
        try {

            SecretKeySpec skeySpec = new SecretKeySpec(llave.getBytes(), "AES");
            Cipher aesCipherForEncryption = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            //aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec("X6QA0P13-98Z0-93".getBytes()));
            aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec("X6QA0P13-98Z0-00".getBytes()));
            byte[] byteDataToEncrypt = strDataToEncrypt.getBytes("UTF-8");
            byte[] byteCipherText = aesCipherForEncryption.doFinal(byteDataToEncrypt);
            String strCipherText = Base64.encodeBase64String(byteCipherText);

            response.setBean(strCipherText);
            response.setRc("0");

        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            try {
                response.setRc("-1");
                 System.out.println(response.getMsg());
                 System.out.println("Error: "+ ex);
            } catch (Exception ex1) {
                response.setRc("-2000");
                response.setMsg("Error General en el servicio");
            }
        } finally {
             System.out.println("*** Finaliza encrypt ***");
            return response;
        }        
    }
    
    
}
