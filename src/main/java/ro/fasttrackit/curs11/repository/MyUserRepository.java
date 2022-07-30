package ro.fasttrackit.curs11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.model.security.MyUser;

import java.util.Optional;

public interface MyUserRepository extends MongoRepository<MyUser, String> {

  Optional<MyUser> findByUserName(String username);
}
