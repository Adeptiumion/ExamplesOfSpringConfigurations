package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/*@Component("FrogBean")*/
public class AnnotatedFrogQualifier extends AbstractAnimal implements Pet {
    public static Logger frogLogger = Logger.getLogger(Dog.class.getName());



    public AnnotatedFrogQualifier(/*@Value("${defaultMammals}")*/ boolean isMammals) {
        super(isMammals);
        frogLogger.info("Frog been is created =)");
    }


    @Override
    public void voice() {
        System.out.println("Qua-qua");
    }
}
