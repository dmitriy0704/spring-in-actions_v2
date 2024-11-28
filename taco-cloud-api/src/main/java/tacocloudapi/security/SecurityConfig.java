package tacocloudapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import tacocloudapi.data.MyUser;

@Configuration
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            MyUser myUser = userRepository.findByUsername(username);
            if (myUser == null) return myUser;
            throw new UsernameNotFoundException("User " + username + "not found");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .cors().disable()
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers(HttpMethod.POST, "/ingredients").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/ingredients").permitAll()
                                .requestMatchers("/", "/**").permitAll()
                )
                .formLogin(
                        formLogin -> formLogin
                                .loginPage("/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/design", true)
                )
                .build();
    }
}
