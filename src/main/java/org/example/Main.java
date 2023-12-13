package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        exampleInversionOfControlWithoutSpring();
//        exampleInversionOfControlWithSpring();
//        exampleWithoutDependencyInjection();
//        exampleWithNotFullDependencyInjection();
//        exampleWithDIWithConstructor();
//        exampleWithDIWithSetter();
//        exampleDIWithValues();
//        exampleDIWithValuesAndValuesFromProperties();
//        exampleBeanScope();
//        exampleBeanScopeAndShowSingleton();
//        exampleBeanScopeAndShowPrototype();
//        exampleInitAndDestroyOfBean();
//        exampleCreateBeanWithAnnotatedClassWithConstructor();
//        exampleCreateBeanWithAnnotatedClassWithSetter();
//        exampleQualifierBeans();
//        exampleJavaConfig();
        exampleFullJavaConfig();


    }


    public static void exampleInversionOfControlWithoutSpring() {
        // Without Spring Application Context.

        Pet dogPet = new Dog(true);
        dogPet.voice();
        System.out.println(dogPet);

        System.out.println("\n");

        Pet catPet = new Cat();
        catPet.voice();
        System.out.println(catPet);

        System.out.println("\n\n\n");
    }

    public static void exampleInversionOfControlWithSpring() {
        // With Spring.
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig.xml");

        // Можно кастить.
        Pet springDogPet = (Dog) context.getBean("someDog");
        springDogPet.voice();
        System.out.println(springDogPet);

        System.out.println("\n");

        // А можно воспользоваться рефлексией.
        Pet springCatPet = context.getBean("someCat", Cat.class);
        springCatPet.voice();
        System.out.println(springCatPet);

        context.close();
    }

    public static void exampleWithoutDependencyInjection() {
        Pet dog = new Dog(true);
        Person person = new Person(dog);
        person.callYourPet();

        System.out.println("\n");

        new Person(new Cat()).callYourPet();
    }

    public static void exampleWithNotFullDependencyInjection() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig.xml");

        Pet cat = context.getBean("someCat", Cat.class);
        Person person = new Person(cat);
        person.callYourPet();

        context.close();
    }

    // DI - Dependency Injection
    public static void exampleWithDIWithConstructor() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig.xml");
        Person person = context.getBean("somePersonWithConstructor", Person.class);
        /*

        fragment of xmlConfig:

        <bean id="someDog" class="org.example.Dog">
        <constructor-arg value="true"/>
        </bean>

        <bean id="someCat" class="org.example.Cat"/>

        <bean id="somePersonWithConstructor" class="org.example.Person">
        <constructor-arg ref="someDog"/>
        </bean>

         */

        person.callYourPet();

        context.close();
    }

    public static void exampleWithDIWithSetter() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig.xml");
        Person person = context.getBean("somePersonWithSetter", Person.class);
        /*

        fragment of xmlConfig:

        <bean id="someDog" class="org.example.Dog">
        <constructor-arg value="true"/>
        </bean>

        <bean id="someCat" class="org.example.Cat"/>

        <bean id="somePersonWithConstructor" class="org.example.Person">
        <constructor-arg ref="someDog"/>
        </bean>

        <bean id="somePersonWithSetter" class="org.example.Person">
        <property name="petOfPerson" ref="someDog" />
        </bean>

        */

        person.callYourPet();

        context.close();
    }

    public static void exampleDIWithValues() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig.xml");
        Person person = context.getBean("somePersonWithSetterAndValues", Person.class);
        person.callYourPet();
        System.out.println(person.getAge());
        System.out.println(person.getName());
        context.close();
    }

    public static void exampleDIWithValuesAndValuesFromProperties() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig.xml");
        Person person = context.getBean("somePersonWithSetterAndValuesFromProperties", Person.class);
        person.callYourPet();
        System.out.println(person.getAge());
        System.out.println(person.getName());
        context.close();
    }

    public static void exampleBeanScope() {
        // Можно читать информацию из n-го кол-ва xml-файлов.
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig_2.xml", "xmlConfig.xml");

        Pet petCat = context.getBean("someCatFromConfig_2", Cat.class);
        Pet petCat_2 = context.getBean("someCatFromConfig_2", Cat.class);
        Pet petCat_3 = context.getBean("someCat", Cat.class);
        System.out.println("Переменные(petCat, petCat_2) имеют одну ссылку объекта? - " + (petCat == petCat_2));
        System.out.println("Переменные(petCat_2, petCat_3) имеют одну ссылку объекта? - " + (petCat_3 == petCat_2));

        context.close();
    }

    public static void exampleBeanScopeAndShowSingleton() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig_2.xml", "xmlConfig.xml");

        Cat petCat_1 = context.getBean("someCatFromConfig_2", Cat.class);
        petCat_1.setName("Zhora");

        Cat petCat_2 = context.getBean("someCatFromConfig_2", Cat.class);
        petCat_2.setName("Barsik");

        System.out.println(petCat_1.getName());
        System.out.println(petCat_2.getName());

        context.close();
    }

    public static void exampleBeanScopeAndShowPrototype() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig_3.xml");

        Cat petCat_1 = context.getBean("someCatFromConfig_3", Cat.class);
        petCat_1.setName("Zhora");

        Cat petCat_2 = context.getBean("someCatFromConfig_3", Cat.class);
        petCat_2.setName("Barsik");

        System.out.println(petCat_1.getName());
        System.out.println(petCat_2.getName());

        context.close();
    }

    public static void exampleInitAndDestroyOfBean() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlConfig_3.xml");

        Dog myDog = context.getBean("someDogFromConfig_3", Dog.class);
        myDog.voice();

        context.close();
    }

    public static void exampleCreateBeanWithAnnotatedClassWithConstructor() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotatedConfig.xml");

        AnnotatedPerson person = context.getBean("PersonBean", AnnotatedPerson.class);
        person.callYourPet();

        context.close();
    }

    public static void exampleCreateBeanWithAnnotatedClassWithSetter() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotatedConfig.xml");

        AnnotatedAnotherPerson person = context.getBean("AnotherPersonBean", AnnotatedAnotherPerson.class);
        person.callYourPet();


        context.close();
    }

    public static void exampleQualifierBeans() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotatedConfig.xml");
        AnnotatedPersonQualifier person = context.getBean("PersonQualifierBean", AnnotatedPersonQualifier.class);
        person.callYourPet();
        context.close();
    }

    public static void exampleJavaConfig() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        Person person = context.getBean("PersonBean", AnnotatedPerson.class);
        person.callYourPet();
        context.close();


    }

    public static void exampleFullJavaConfig() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(FullConfig.class);
        Pet cat = context.getBean("cat", Cat.class);
        cat.voice();
        Pet cat_2 = context.getBean("cat", Cat.class);
        cat_2.voice();

        System.out.println();
        System.out.println();

        Person person = context.getBean("person", Person.class);
        person.callYourPet();


    }


}