package sully.group.sa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping(path = "test")

public class TestController {

    String strChar ="Chaine de cacatère trasmise par SA";
    String strChar1 ="Chaine de cacatère trasmise par SA 2";
    @GetMapping(path = "string")
    public String etString(){
      return  strChar;
    }
   @GetMapping(path = "calc")
   public int sum(){
      int  a=2;
        int b=5;
        return a+b;
   }
   @GetMapping()
   public List<String> getList(){

        return List.of( strChar,strChar1);
   }


}
