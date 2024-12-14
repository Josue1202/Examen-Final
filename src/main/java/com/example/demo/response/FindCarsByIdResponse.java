package com.example.demo.response;

import com.example.demo.dto.CarDto;

public record FindCarsByIdResponse(String code,
                                   String error,
                                   CarDto car) {
}
