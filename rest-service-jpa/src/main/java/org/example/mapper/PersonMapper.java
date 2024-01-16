package org.example.mapper;

import org.example.model.Person;
import org.example.model.PersonCreateRequest;
import org.example.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

    Person mapToEntity(PersonCreateRequest person);

    PersonResponse mapToResponse(Person person);

    List<PersonResponse> mapToResponse(List<Person> people);

}