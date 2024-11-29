package authserver;

import authserver.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;


@SpringBootApplication
public class AuthServerApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApp.class, args);
    }

    @Bean
    public ApplicationRunner dataLoader(
            UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            repo.save(
                    new User("habuma",
                            encoder.encode("password"),
                            Collections.singletonList(
                                    new SimpleGrantedAuthority("ROLE_ADMIN")))
            );
            repo.save(
                    new User("tacochef",
                            encoder.encode("password"),
                            Collections.singletonList(
                                    new SimpleGrantedAuthority("ROLE_ADMIN")))
            );
        };
    }
}
