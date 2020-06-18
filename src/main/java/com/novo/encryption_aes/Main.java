/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novo.encryption_aes;

/**
 *
 * @author lmirabal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        Utils util = new Utils();
        String cadena = "Hola, Como estas?";
        String llave="5f0ff155a7d081b34985af34367f83d5";
        ResponseTO response = new ResponseTO();
        response = util.encrypt(cadena, llave);
        
        System.out.println("Encript response: "+response.getBean());
        
        response = util.decrypt(response.getBean(), llave);
        
        System.out.println("Decript response: "+response.getBean());        
        
    }
    
}
