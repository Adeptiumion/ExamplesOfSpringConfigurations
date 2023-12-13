package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.logging.Logger;

@Configuration
public class FullConfig {

    public static Logger fullConfigurationLogger = Logger.getLogger(FullConfig.class.getName());

    @Bean
    @Scope("singleton") // or prototype
    public Cat cat() {
        Cat cat = new Cat();
        fullConfigurationLogger.info(" ★Cat bean has been creating!★");
        return cat;
    }

    @Bean
    public Person person(){
        fullConfigurationLogger.info(" ★Person bean has been creating!★");
        return new Person(cat());
    }


}
