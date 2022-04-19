package technical.test.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import technical.test.api.model.CustomerModel;
import technical.test.api.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Mono<CustomerModel> insert(CustomerModel customerModel) {
        return customerRepository.insert(customerModel);
    }

    public Flux<CustomerModel> getAll() {
        return customerRepository.findAll();
    }
}
