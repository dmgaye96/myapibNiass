package sa.code.myapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sa.code.myapi.model.Restaurant;
import sa.code.myapi.repository.RestaurantRepository;

import java.util.List;

@RestController
@CrossOrigin
public class RestoController {
    @Autowired
    RestaurantRepository restaurantRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/addResto",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Restaurant save(@RequestBody(required = false) Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping(value = "/updateResto",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Restaurant update(@RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/findAllResto",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public List<Restaurant> findAll(){
        return restaurantRepository.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/findRestoByName",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public List<Restaurant> findByName(@RequestParam("name") String name){
        return restaurantRepository.findByNomIgnoreCase(name);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/searchResto",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public List<Restaurant> search(@RequestParam("name") String name){
        return restaurantRepository.findByNomLikeIgnoreCase("%"+name+"%");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping(value = "/deleteResto",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@RequestBody Restaurant restaurant){
        restaurantRepository.delete(restaurant);
    }
}
