package sa.code.myapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.code.myapi.model.Car;
import sa.code.myapi.model.RoleName;

import java.util.Optional;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
