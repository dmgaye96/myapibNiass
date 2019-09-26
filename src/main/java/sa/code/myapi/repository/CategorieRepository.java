package sa.code.myapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sa.code.myapi.model.Categorie;
import sa.code.myapi.model.Restaurant;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
}
