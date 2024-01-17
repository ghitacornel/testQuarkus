package org.example;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.example.model.Person;
import org.example.model.PersonResponse;
import org.example.repository.PersonRepository;
import org.example.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@QuarkusTest
@Transactional
class PersonFindByNameTest {

    @Inject
    PersonRepository repository;

    @Inject
    PersonService service;

    @Test
    @SneakyThrows
    void findByName() {

        repository.persist(Person.builder().name("A").build());
        repository.persist(Person.builder().name("B").build());
        repository.persist(Person.builder().name("BB").build());

        List<PersonResponse> persons = service.findByName("B");
        Assertions.assertEquals("[PersonResponse(id=2, name=B)]", persons.toString());
    }
}