package org.example;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.example.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@QuarkusTest
@Transactional
class SpringDataTest {

    @Inject
    PersonRepository repository;

    @Inject
    PersonService service;

    @Test
    @SneakyThrows
    void findAll() {

        repository.save(Person.builder().name("A").build());

        List<Person> all = service.findAll();
        Assertions.assertEquals("[Person(id=1, name=A)]", all.toString());

    }
}