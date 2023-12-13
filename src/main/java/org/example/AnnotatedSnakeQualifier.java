package org.example;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("SnakeBean")
public class AnnotatedSnakeQualifier extends AbstractAnimal implements Pet {
    public static Logger snakeLogger = Logger.getLogger(Dog.class.getName());

    public AnnotatedSnakeQualifier() {
        super(false);
        snakeLogger.info("Snake been is created =)");
    }

    @Override
    public void voice() {
        System.out.println("Shshsh");
    }
}
