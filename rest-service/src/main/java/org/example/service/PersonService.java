package org.example.service;

import jakarta.inject.Singleton;
import org.example.model.Person;

@Singleton
public class PersonService {

    public Person save(Person person) {
        person.setId(person.getId() + 1);
        person.setName(person.getName() + " " + person.getName());
        return person;
    }

}
