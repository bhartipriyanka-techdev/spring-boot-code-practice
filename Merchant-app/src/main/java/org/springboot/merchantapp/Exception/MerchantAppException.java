package org.springboot.merchantapp.Exception;

import org.springboot.merchantapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class MerchantAppException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MerchantNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleMerchantAppException(MerchantNotFoundException exception){
       ResponseStructure<String>  responseStructure = new ResponseStructure<>();
       responseStructure.setData("Merchant Not Found....!");
       responseStructure.setMessage(exception.getMessage());
       responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseStructure);
    }
}
