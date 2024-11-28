package restclient.data;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class Client {

    private final RestTemplate rest;


    public Client(RestTemplate rest) {
        this.rest = rest;
    }

    public Ingredient getIngredientById(String ingredientId) {
        return rest.getForObject("http://localhost:8080/data-api/ingredients/{id}",
                Ingredient.class, ingredientId);
    }
}
