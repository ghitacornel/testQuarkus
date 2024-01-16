package org.example.mapper;

import org.example.model.Person;
import org.example.model.PersonCreateRequest;
import org.example.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

    // NOTE
    // need to have unique method names otherwise it will generate bad code !!!

    @Mapping(target = "id", ignore = true)
    Person map(PersonCreateRequest person);

    PersonResponse map(Person person);

    List<PersonResponse> map(List<Person> people);

}