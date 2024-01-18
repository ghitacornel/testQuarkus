package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Singleton;
import org.example.model.Person;

@Singleton
public class PersonRepository implements PanacheRepository<Person> {

}
