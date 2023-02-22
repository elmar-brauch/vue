package de.bsi.vue.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@CrossOrigin(origins = "*")
public class CarController {

    List<Car> cars = new ArrayList<>();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> readCars() {
        return cars;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCar(@RequestBody Car newCar) {
        cars.add(newCar);
    }

}
