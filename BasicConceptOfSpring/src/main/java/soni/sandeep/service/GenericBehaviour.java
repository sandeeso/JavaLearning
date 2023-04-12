package soni.sandeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericBehaviour {

    @Autowired
    AdditionalBehaviour additionalBehaviour;
    public void print() {
        System.out.println("hello World");
        additionalBehaviour.display();
    }
}
