package technical.test.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import technical.test.api.model.CustomerModel;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<CustomerModel, String> {
}
