package org.example;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("FoxBean") // айдишник
public class AnnotatedFox extends AbstractAnimal implements Pet{
    public static Logger foxLogger = Logger.getLogger(AnnotatedFox.class.getName());

    public AnnotatedFox() {
        super(true);
        foxLogger.info("Fox been is created =)");
    }

    @Override
    public void voice() {
        System.out.println("Yip-yap");
    }
}
