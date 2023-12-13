package org.example;

import org.apache.commons.logging.Log;

import java.util.logging.Logger;


public class Person {

    private static Logger personLogger = Logger.getLogger(Person.class.getName());
    private Pet petOfPerson;
    private String name;
    private int age;


    public Person(Pet petOfPerson) {
        this.petOfPerson = petOfPerson;
        personLogger.info("Person been is created!");
    }

    public Person(){
        personLogger.info("Person been is created!");
    }

    public void setPetOfPerson(Pet petOfPerson) {
        this.petOfPerson = petOfPerson;
        personLogger.info("Pet setter finished work!");
    }

    public void callYourPet(){
        System.out.println("Hello, my lovely Pet!");
        this.petOfPerson.voice();
    }

    public void setAge(int age) {
        this.age = age;
        personLogger.info("Age setter finished work!");
    }

    public void setName(String name) {
        this.name = name;
        personLogger.info("Name setter finished work!");
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Pet getPetOfPerson() {
        return petOfPerson;
    }
}
