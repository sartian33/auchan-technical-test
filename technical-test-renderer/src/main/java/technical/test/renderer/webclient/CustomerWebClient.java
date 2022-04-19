package technical.test.renderer.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import technical.test.renderer.model.CustomerModel;

@Component
public class CustomerWebClient {

    WebClient client = WebClient.create("http://localhost:8080");

    public Flux<CustomerModel> getCustomers() {

        Flux<CustomerModel> customerFlux = client.get()
                .uri("/customer/all")
                .retrieve()
                .bodyToFlux(CustomerModel.class);
        return customerFlux;
    }


    public Mono<CustomerModel> addCustomer(CustomerModel customerModel) {

        Mono<CustomerModel> customerMono = client.post()
                .uri("/customer/add")
                .body(Mono.just(customerModel), CustomerModel.class)
                .retrieve()
                .bodyToMono(CustomerModel.class);
        return customerMono;

    }
}
