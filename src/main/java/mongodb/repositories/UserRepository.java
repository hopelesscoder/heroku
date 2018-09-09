package mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongodb.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
