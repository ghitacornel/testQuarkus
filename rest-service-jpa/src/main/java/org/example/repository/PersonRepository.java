package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Singleton;
import org.example.model.Person;

import java.util.List;

@Singleton
public class PersonRepository implements PanacheRepository<Person> {

    public List<Person> findByName(String name) {
        return list("#Person.findByName", name).stream().toList();
    }

}
