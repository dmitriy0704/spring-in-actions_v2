package restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import restclient.data.Client;
import restclient.data.Ingredient;

@SpringBootApplication
@Slf4j
public class TacocloudRestclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacocloudRestclientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


//	@Bean
//	public CommandLineRunner fetchIngredients(Client tacoCloudClient) {
//		return args -> {
//			log.info("----------------------- GET -------------------------");
//			log.info("GETTING INGREDIENT BY IDE");
//			log.info("Ingredient:  " + tacoCloudClient.getIngredientById_response("CHED"));
//		};
//	}

	@Bean
	public CommandLineRunner addAnIngredient(Client tacoCloudClient) {
		return args -> {
			log.info("----------------------- POST -------------------------");
			Ingredient chix = new Ingredient("CHIX", "Shredded Chicken", Ingredient.Type.PROTEIN);
			Ingredient chixAfter = tacoCloudClient.createIngredient(chix);
			log.info("AFTER=1:  " + chixAfter);
//      Ingredient beefFajita = new Ingredient("BFFJ", "Beef Fajita", Ingredient.Type.PROTEIN);
//      URI uri = tacoCloudClient.createIngredient(beefFajita);
//      log.info("AFTER-2:  " + uri);
//      Ingredient shrimp = new Ingredient("SHMP", "Shrimp", Ingredient.Type.PROTEIN);
//      Ingredient shrimpAfter = tacoCloudClient.createIngredient(shrimp);
//      log.info("AFTER-3:  " + shrimpAfter);
		};
	}
}
