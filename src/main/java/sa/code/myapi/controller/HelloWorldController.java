package sa.code.myapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sa.code.myapi.model.Car;
import sa.code.myapi.repository.CarRepository;

import java.util.List;

@RestController
@CrossOrigin
public class HelloWorldController {

    @Autowired
    private CarRepository carRepository;

    @PreAuthorize("hasAuthority('ROLE_CLIENT')")
    @RequestMapping({ "/cars" })
    public List<Car> allCars() {
        return carRepository.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping({ "/car/add" })
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

}