package technical.test.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import technical.test.api.model.CustomerModel;
import technical.test.api.services.CustomerService;

@Component
public class CustomerHandler {
    @Autowired
    private CustomerService customerService;

    public Mono<ServerResponse> addCustomer(ServerRequest serverRequest) { //TODO check
        return serverRequest.bodyToMono(CustomerModel.class)
                .flatMap(customerService::insert)
                .flatMap(customer -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(customer)));

    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok().body(customerService.getAll(), CustomerModel.class);
    }
}
