package org.example.service;

import jakarta.inject.Singleton;
import org.example.model.RequestDto;

@Singleton
public class BusinessService {

    public RequestDto findById(Integer id) {
        return new RequestDto(1, "John");
    }

    public RequestDto save(RequestDto person) {
        return person;
    }
}
