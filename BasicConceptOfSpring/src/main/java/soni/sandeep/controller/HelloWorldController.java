package soni.sandeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soni.sandeep.service.GenericBehaviour;

@RestController
public class HelloWorldController {

    GenericBehaviour genericBehaviour = new GenericBehaviour();


    @RequestMapping ("/print")
    public String hello() {

        genericBehaviour.print();
        return "it is printed";
    }
}

