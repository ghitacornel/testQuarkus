package org.example.service;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.model.Person;
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

}
