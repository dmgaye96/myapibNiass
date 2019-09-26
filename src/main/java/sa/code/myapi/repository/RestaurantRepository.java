package sa.code.myapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sa.code.myapi.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    List<Restaurant> findByNomIgnoreCase(String nom);
    List<Restaurant> findByNomLikeIgnoreCase(String nom);
}
