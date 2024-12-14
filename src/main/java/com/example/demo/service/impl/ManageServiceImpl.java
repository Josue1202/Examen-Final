package com.example.demo.service.impl;

import com.example.demo.dto.CarDto;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    //---------------------------------------------------------------------
    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            CarDto carDto = new CarDto(car.getCar_id(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getLicense_plate(),
                    car.getOwner_name(),
                    car.getOwner_contact(),
                    car.getEngine_type(),
                    car.getColor()
                    );
            cars.add(carDto);
        });
        return cars;

    }

    //------------------------------------------------------------------
    @Override
    public Optional<CarDto> getAllUsersById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDto(car.getCar_id(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getLicense_plate(),
                car.getOwner_name(),
                car.getOwner_contact(),
                car.getEngine_type(),
                car.getColor()
                ));

    }

    //--------------------------------------------------------------------
    @Override
    public Optional<CarDto> getCarsById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDto(car.getCar_id(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getLicense_plate(),
                car.getOwner_name(),
                car.getOwner_contact(),
                car.getEngine_type(),
                car.getColor()
                ));

    }

    //---------------------------------------------------------------------
    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.car_id());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setLicense_plate(carDto.license_plate());
            car.setOwner_name(carDto.owner_name());
            car.setOwner_contact(carDto.owner_contact());
            car.setEngine_type(carDto.engine_type());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    //---------------------------------------------------------------------
    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    //---------------------------------------------------------------------
    @Override
    public boolean addCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.car_id());
        if(optional.isPresent())
            return false;
        else {
            Car car = new Car();
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setLicense_plate(carDto.license_plate());
            car.setOwner_name(carDto.owner_name());
            car.setOwner_contact(carDto.owner_contact());
            car.setEngine_type(carDto.engine_type());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;
        }


    }

}
