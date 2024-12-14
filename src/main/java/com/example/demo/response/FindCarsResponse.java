package com.example.demo.response;

import com.example.demo.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
