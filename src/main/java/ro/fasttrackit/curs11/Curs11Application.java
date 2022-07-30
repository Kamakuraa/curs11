package ro.fasttrackit.curs11;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs11.model.entity.LocationEntity;
import ro.fasttrackit.curs11.model.entity.TrainEntity;
import ro.fasttrackit.curs11.model.security.MyUser;
import ro.fasttrackit.curs11.repository.LocationRepository;
import ro.fasttrackit.curs11.repository.MyUserRepository;
import ro.fasttrackit.curs11.repository.TrainRepository;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Curs11Application {

  public static void main(String[] args) {
    SpringApplication.run (Curs11Application.class, args);
  }
  CommandLineRunner addUsers(MyUserRepository repo) {
    return args -> repo.saveAll(List.of(
      new MyUser (UUID.randomUUID().toString(), "admin", "admin", "Oradea", List.of("ROLE_ADMIN", "READ", "WRITE")),
      new MyUser(UUID.randomUUID().toString(), "user", "user", "Cluj", List.of("ROLE_ADMIN", "READ", "WRITE"))
    ));
  }
  @Bean
  CommandLineRunner atStartup(TrainRepository trainRepository,
                              LocationRepository locationRepository){
    return args -> {
      trainRepository.save (
        TrainEntity.builder ()
          .model ("Cluj 1988")
          .carts (10)
          .locationId (locationRepository.save (new LocationEntity (null,"Oradea")).locationId ())
        .build ());

      trainRepository.save (
        TrainEntity.builder ()
          .model ("Sageata")
          .carts (3)
          .locationId (locationRepository.save (new LocationEntity (null,"Timisoara")).locationId ())
          .build ());


    };
  }

}
