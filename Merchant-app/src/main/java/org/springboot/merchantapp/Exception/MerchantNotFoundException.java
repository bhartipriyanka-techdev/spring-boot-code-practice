package org.springboot.merchantapp.Exception;

public class MerchantNotFoundException extends RuntimeException{
    public  MerchantNotFoundException(String message){
        super(message);
    }
}
