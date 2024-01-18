package org.example.service;

import jakarta.inject.Singleton;
import org.example.exceptions.BusinessException;
import org.example.model.RequestDto;

@Singleton
public class BusinessService {

    public RequestDto process(RequestDto requestDto) {
        if (requestDto.getId() < 0) {
            throw new BusinessException("negative ID");
        }
        return requestDto;
    }
}
