package org.example.service;

import jakarta.inject.Singleton;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.model.RequestDto;

@Singleton
public class ServiceValidationService {

    public RequestDto findById(@Positive Integer id) {
        return new RequestDto(1, "John");
    }

    public RequestDto save(@Valid RequestDto person) {
        return person;
    }
}
