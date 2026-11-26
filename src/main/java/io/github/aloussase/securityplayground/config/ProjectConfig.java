package io.github.aloussase.securityplayground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        final var uds = new InMemoryUserDetailsManager();

        final var user = User.builder()
                .username("aloussase")
                .password("1234")
                .build();

        uds.createUser(user);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
