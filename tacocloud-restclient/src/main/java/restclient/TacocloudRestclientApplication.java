package restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import restclient.data.Client;

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


	@Bean
	public CommandLineRunner fetchIngredients(Client tacoCloudClient) {
		return args -> {
			log.info("----------------------- GET -------------------------");
			log.info("GETTING INGREDIENT BY IDE");
			log.info("Ingredient:  " + tacoCloudClient.getIngredientById("CHED"));
		};
	}

}
