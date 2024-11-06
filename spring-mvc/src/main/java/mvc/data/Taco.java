package mvc.data;

import lombok.Data;

import java.util.List;

@Data
public class Taco {

    private Long id;
    private String name;
    private List<Ingredient> ingredients;
}
