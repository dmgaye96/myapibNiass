package sa.code.myapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sa.code.myapi.model.Categorie;
import sa.code.myapi.model.Restaurant;
import sa.code.myapi.repository.CategorieRepository;
import sa.code.myapi.repository.RestaurantRepository;

import java.util.List;

@RestController
@CrossOrigin
public class ProduitController {

    @Autowired
    CategorieRepository categorieRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @GetMapping(value = "/categories",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Categorie> categroies(){
        return categorieRepository.findAll();
    }
}
