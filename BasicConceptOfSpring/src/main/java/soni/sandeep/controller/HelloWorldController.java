package soni.sandeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soni.sandeep.enums.FeeRate;
import soni.sandeep.service.GenericBehaviour;

import java.io.File;
import java.net.http.HttpClient;

@RestController
public class HelloWorldController {

    @Autowired
    GenericBehaviour genericBehaviour;


    @RequestMapping ("/print")
    public String hello() {
        genericBehaviour.print();

        System.out.println(FeeRate.FR1 + "***************" + FeeRate.FR1.getFeer() );

        return "it is printed";

    }
}

