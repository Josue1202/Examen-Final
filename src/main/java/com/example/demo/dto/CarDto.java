package com.example.demo.dto;


public record CarDto(Integer car_id,
                     String make,
                     String model,
                     Integer year,
                     String license_plate,
                     String owner_name,
                     String owner_contact,
                     String engine_type,
                     String color
                     ) {
}
