package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("PersonBean")
public class AnnotatedPerson extends Person{

    @Autowired
    public AnnotatedPerson(@Qualifier("FoxBean") Pet petOfPerson){
        super(petOfPerson);
    }

    public AnnotatedPerson(){
        super();
    }

}
