package org.example.mapper;

import org.example.model.Person;
import org.example.model.PersonCreateRequest;
import org.example.model.PersonResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

    // NOTE
    // need to have unique method names otherwise it will generate bad code !!!

    Person mapToEntity(PersonCreateRequest person);

    PersonResponse mapToResponse(Person person);

    List<PersonResponse> mapToResponse(List<Person> people);

}