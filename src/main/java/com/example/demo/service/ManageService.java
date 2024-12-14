package com.example.demo.service;

import com.example.demo.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDto> getAllUsersById(int id) throws Exception;

    Optional<CarDto> getCarsById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDto carDto) throws Exception;

}
