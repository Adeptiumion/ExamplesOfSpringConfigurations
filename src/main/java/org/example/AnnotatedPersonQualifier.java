package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Component("PersonQualifierBean")
public class AnnotatedPersonQualifier extends Person {

    @Autowired
    @Qualifier("SnakeBean")
    private Pet annotatedPetAutowiredQualifier;
    private static final Logger annotatedPersonQualifierLogger = Logger.getLogger(Person.class.getName());


    public AnnotatedPersonQualifier(Pet petOfPerson) {
        this.annotatedPetAutowiredQualifier = petOfPerson;
        annotatedPersonQualifierLogger.info("AnnotatedPersonQualifier been is created!");

    }

    public AnnotatedPersonQualifier() {
        super();
        annotatedPersonQualifierLogger.info("AnnotatedPersonQualifier been is created!");
    }

    @PostConstruct
    public void init(){

        annotatedPersonQualifierLogger.info("Init method of Dog class is running!");
    }

    @PreDestroy
    public void destroy(){

        annotatedPersonQualifierLogger.info("Destroy method of Dog class is running!");
    }

    @Override
    public void callYourPet() {
        System.out.println("Come to me my lovely pet!");
        annotatedPetAutowiredQualifier.voice();
    }
}
