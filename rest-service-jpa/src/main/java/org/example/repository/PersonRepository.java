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

    public List<Person> findByNameBad(String name) {
        return list("select p from Person p where p.name = ?1 order by p.id", name).stream().toList();
        // just modify the query and add an order by p.id, p.notExistingProperty
    }

}
