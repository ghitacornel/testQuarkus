package org.example.mapper;

import org.example.model.Person;
import org.example.model.PersonRequest;
import org.example.model.PersonResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

    Person map(PersonRequest person);

    PersonResponse map(Person person);

    List<PersonResponse> map(List<Person> people);

}