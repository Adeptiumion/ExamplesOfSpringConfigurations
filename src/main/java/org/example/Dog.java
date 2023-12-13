package org.example;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;


public class Dog extends AbstractAnimal implements Pet {
    public static Logger dogLogger = Logger.getLogger(Dog.class.getName());

    public Dog(boolean isMammals) {

        super(isMammals);
        dogLogger.info("Dog been is created =)");
    }


    public void init(){
        dogLogger.info("Init method of Dog class is running!");
    }

    public void destroy(){
        dogLogger.info("Destroy method of Dog class is running!");
    }

    @Override
    public void voice() {
        System.out.println("Bow-bow");
    }
}
