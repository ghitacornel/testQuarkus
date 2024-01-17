package org.example.service;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.mapper.PersonMapper;
import org.example.model.Person;
import org.example.model.PersonCreateRequest;
import org.example.model.PersonResponse;
import org.example.repository.PersonRepository;

import java.util.List;

@Singleton
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    public List<PersonResponse> findAll() {
        return mapper.map(repository.listAll());
    }

    public PersonResponse findById(Long id) {
        return mapper.map(repository.findById(id));
    }

    public List<PersonResponse> findByName(String name) {
        return mapper.map(repository.findByName(name));
    }

    public PersonResponse save(PersonCreateRequest request) {
        Person person = mapper.map(request);
        repository.persist(person);
        return mapper.map(person);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
