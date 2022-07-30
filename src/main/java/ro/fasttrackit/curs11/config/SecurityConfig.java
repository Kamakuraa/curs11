package ro.fasttrackit.curs11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests (
        auth -> auth
          .mvcMatchers ("/permit").permitAll ()
          .mvcMatchers ("/me").authenticated ()
          .mvcMatchers ("/trains").authenticated ()
          .anyRequest ().denyAll ()
      )
      .formLogin ()
      .and ()
      .httpBasic ();
    return http.build ();
  }
}
