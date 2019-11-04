/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.py2_201520498;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
/**
 *
 * @author herre
 */
public class Sha256 {

   
    public Sha256() {
       
    }
    
    public String SHa(String Pass){
     try 
        { 
         return toHexString(getSHA(Pass));
  
        } 
        catch (NoSuchAlgorithmException e) {  
            System.out.println("Exception thrown for incorrect algorithm: " + e);  
        }  
     return null;
    }
     public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        BigInteger number = new BigInteger(1, hash);  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
        return hexString.toString();  
    } 
    
}
