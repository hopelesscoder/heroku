package mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongodb.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
