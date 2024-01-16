package org.example.mapper;

import org.example.model.Person;
import org.example.model.PersonCreateRequest;
import org.example.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

    @Mapping(target = "id", ignore = true)
    Person map(PersonCreateRequest person);

    PersonResponse map(Person person);

    List<PersonResponse> map(List<Person> people);

}