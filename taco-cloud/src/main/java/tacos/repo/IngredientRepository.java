package tacos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import tacos.data.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);


}
