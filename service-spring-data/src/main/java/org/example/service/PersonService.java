package org.example.service;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.model.Person;
import org.example.model.PersonProjection;
import org.example.repository.PersonRepository;

import java.util.List;

@Singleton
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<Person> findByNameLike(String name) {
        return repository.findByNameLike("%" + name + "%");
    }

    public List<String> findAllDistinctNames() {
        return repository.findAllDistinctNames();
    }

    public List<PersonProjection> findAllProjections() {
        return repository.findAllProjections();
    }

}
