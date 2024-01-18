package org.example.repository;

import org.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByName(String name);

    @Query("select p from Person p where p.name like :name order by p.id")
    List<Person> findByNameLike(@Param("name") String name);

    @Query("select distinct p.name from Person p order by name")
    List<String> findAllDistinctNames();

}
