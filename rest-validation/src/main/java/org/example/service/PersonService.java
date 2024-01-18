package org.example.service;

import jakarta.inject.Singleton;
import org.example.model.Person;

@Singleton
public class PersonService {

    public Person findById(Integer id) {
        return new Person(1, "John");
    }

    public Person save(Person person) {
        return person;
    }
}
