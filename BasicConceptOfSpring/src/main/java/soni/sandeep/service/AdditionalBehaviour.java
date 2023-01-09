package soni.sandeep.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class AdditionalBehaviour {

    public void display() {
        System.out.println("application is running;");
    }
}
