package org.example;

import org.springframework.stereotype.Component;

import javax.lang.model.element.Name;
import java.util.Objects;
import java.util.logging.Logger;


public class Cat extends AbstractAnimal implements Pet{

    public static Logger catLogger = Logger.getLogger(Cat.class.getName());

    private String name;


    public Cat() {
        super(true);
        catLogger.info("Cat been is created =)");
    }

    @Override
    public String objectToString() {
        return super.objectToString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void voice() {

        System.out.println("Meow-meow");
    }
}
