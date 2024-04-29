package org.springboot.springbootoractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping(value = "/show")
    @ResponseBody
    public String show(){
        return"Welcome To Springboot Class Application...!!";

    }
    @GetMapping(value = "/sum")
    @ResponseBody
    public String getSum(@RequestParam(name="number1")int number1,@RequestParam(name="number2") int number2){
        return number1 +"+"+number2 +"="+(number1+number2);
    }

    @GetMapping(value = "/dif")
    @ResponseBody
    public String getDif(@RequestParam(name="number1")int number1,@RequestParam(name="number2") int number2){
        return number1 +"-"+number2 +"="+(number1-number2);
    }
    @GetMapping(value = "/product")
    @ResponseBody
    public String getProduct(@RequestParam(name="number1")int number1,@RequestParam(name="number2") int number2){
        return number1 +"*"+number2 +"="+(number1*number2);
    }
}
