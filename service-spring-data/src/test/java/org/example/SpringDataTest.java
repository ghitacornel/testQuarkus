package org.example;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.example.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
@TestTransaction
class SpringDataTest {

    @Inject
    PersonRepository repository;

    @Inject
    PersonService service;

    @Test
    void findAll() {

        repository.save(Person.builder().id(1L).name("A").build());

        Assertions.assertEquals("[Person(id=1, name=A)]", service.findAll().toString());
    }

    @Test
    void findByName() {
        repository.save(Person.builder().id(1L).name("A").build());
        repository.save(Person.builder().id(2L).name("B").build());

        Assertions.assertEquals("Person(id=1, name=A)", service.findByName("A").toString());
        Assertions.assertNull(service.findByName("not matched"));
    }

    @Test
    void findByNameLike() {
        repository.save(Person.builder().id(1L).name("A").build());
        repository.save(Person.builder().id(2L).name("AA").build());
        repository.save(Person.builder().id(3L).name("B").build());

        Assertions.assertEquals("[Person(id=1, name=A), Person(id=2, name=AA)]", service.findByNameLike("A").toString());
    }

    @Test
    void findAllDistinctNames() {
        repository.save(Person.builder().id(1L).name("A").build());
        repository.save(Person.builder().id(2L).name("A").build());
        repository.save(Person.builder().id(3L).name("B").build());

        Assertions.assertEquals("[A, B]", service.findAllDistinctNames().toString());
    }
}