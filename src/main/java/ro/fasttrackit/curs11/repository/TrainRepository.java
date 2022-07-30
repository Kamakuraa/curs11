package ro.fasttrackit.curs11.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.model.entity.TrainEntity;

public interface TrainRepository extends MongoRepository<TrainEntity, String> {
}
