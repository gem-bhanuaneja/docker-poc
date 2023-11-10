package com.example.Dockerspringboot.service;

import com.example.Dockerspringboot.entity.Car;
import com.example.Dockerspringboot.repository.CarRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Cacheable(value = "carCache", key = "#carId")
    public Car getCarById(final Integer carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("No car found for given id"));
        return car;
    }

    public Car saveNewCar(final Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(final Integer mobileId, final Car car) {

        Car savedCar = carRepository.findById(mobileId)
                .orElseThrow(() -> new IllegalArgumentException("No car found for given id"));

        savedCar.setName(ObjectUtils.isNotEmpty(car.getName()) ? car.getName() : savedCar.getName());
        savedCar.setColor(ObjectUtils.isNotEmpty(car.getColor()) ? car.getColor() : savedCar.getColor());
        savedCar.setPrice(ObjectUtils.isNotEmpty(car.getPrice()) ? car.getPrice() : savedCar.getPrice());
        savedCar.setYear(ObjectUtils.isNotEmpty(car.getYear()) ? car.getYear() : savedCar.getYear());

        return carRepository.save(savedCar);
    }

    public String deleteCar(final Integer mobileId) {
        carRepository.deleteById(mobileId);
        return "Car deleted successfully";
    }
}
