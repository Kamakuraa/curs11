package ro.fasttrackit.curs11.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.model.entity.LocationEntity;

public interface LocationRepository extends MongoRepository<LocationEntity, String> {
}
