package technical.test.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import technical.test.api.endpoints.CustomerHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CustomerRouter {
    @Bean
    public RouterFunction<ServerResponse> getRoutesCustomer(CustomerHandler customerHandler) {
        return RouterFunctions.route(GET("/customer/all").and(accept(MediaType.APPLICATION_JSON)), customerHandler::getAll)
                .and(RouterFunctions.route(POST("/customer/add").and(accept(MediaType.APPLICATION_JSON)), customerHandler::addCustomer));
    }
}
