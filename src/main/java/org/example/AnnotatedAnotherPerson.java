package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("AnotherPersonBean")
public class AnnotatedAnotherPerson extends Person{

    public AnnotatedAnotherPerson(Pet petOfPerson){
        super(petOfPerson);
    }

    public AnnotatedAnotherPerson(){
        super();
    }

    @Override
    @Autowired
    @Qualifier("FoxBean")
    public void setPetOfPerson(Pet petOfPerson) {
        super.setPetOfPerson(petOfPerson);
    }
}