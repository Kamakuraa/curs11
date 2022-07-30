package ro.fasttrackit.curs11.model.security;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Document("users")
@Builder
public record MyUser(
  @Id
  String userId,
  String username,
  String password,
  String city,
  List<String> roles
) {
}
