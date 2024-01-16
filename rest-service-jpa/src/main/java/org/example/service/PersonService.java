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
        return mapper.mapToResponse(repository.listAll());
    }

    public PersonResponse findById(Long id) {
        return mapper.mapToResponse(repository.findById(id));
    }

    public PersonResponse save(PersonCreateRequest request) {
        Person person = mapper.mapToEntity(request);
        repository.persist(person);
        return mapper.mapToResponse(person);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
