package authserver;

import authserver.data.MyUser;
import authserver.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class AuthServerApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApp.class, args);
    }

    @Bean
    public ApplicationRunner dataLoader(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            repo.save(
                    new MyUser("habuma",
                            encoder.encode("password"),
                            "ROLE_ADMIN")
            );
            repo.save(
                    new MyUser("tacochef",
                            encoder.encode("password"),
                            "ROLE_ADMIN")
            );
        };
    }
}
