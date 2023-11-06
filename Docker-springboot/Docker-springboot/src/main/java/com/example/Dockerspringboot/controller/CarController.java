package com.example.Dockerspringboot.controller;

import com.example.Dockerspringboot.entity.Car;
import com.example.Dockerspringboot.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class CarController {

    @Autowired
    private CarService carService;


    @Operation(summary = "fetch all cars", description = "Api to fetch all cars details")
    @GetMapping("/get-all-cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched car details successfully",
                    content = {@Content(schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "5XX", description = "Internal Error")})
    public ResponseEntity<List<Car>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(carService.getAllCars());
    }


    @Operation(summary = "fetch mobile by mobile-id", description = "Api to fetch mobile details by mobile-id")
    @GetMapping("/get-by-id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched mobile details successfully",
                    content = {@Content(schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "5XX", description = "Internal Error")})
    public ResponseEntity<Car> findById(final Integer carId) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.getCarById(carId));
    }


    @Operation(summary = "Save new car", description = "Api to save new car entry to database")
    @PostMapping("/save-new-car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saved car details successfully",
                    content = {@Content(schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "5XX", description = "Internal Error")})
    public ResponseEntity<Car> saveNewCar(final Car car) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.saveNewCar(car));
    }


    @Operation(summary = "Update existing car details", description = "Api to update existing car details")
    @PatchMapping("/update-car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated mobile details successfully",
                    content = {@Content(schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "5XX", description = "Internal Error")})
    public ResponseEntity<Car> updateCar(final Integer carId, final Car car) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.updateCar(carId, car));
    }


    @Operation(summary = "Delete existing car details", description = "Api to delete existing car details")
    @DeleteMapping("/delete-car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car mobile details successfully",
                    content = {@Content(schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "5XX", description = "Internal Error")})
    public ResponseEntity<String> deleteCar(final Integer carId) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.deleteCar(carId));
    }



}
