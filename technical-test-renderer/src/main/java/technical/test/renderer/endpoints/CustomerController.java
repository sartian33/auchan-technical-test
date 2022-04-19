package technical.test.renderer.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import technical.test.renderer.model.CustomerModel;
import technical.test.renderer.webclient.CustomerWebClient;

import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired private CustomerWebClient client;

    @GetMapping("/")
    public String getAll(Model model) {
        Flux<CustomerModel> customers = client.getCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new CustomerModel());
        return "index";
    }

    @PostMapping("/customer/add")
    public String add(@Valid CustomerModel customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/";
        }
        Mono<CustomerModel> customerCreated = client.addCustomer(customer);
        model.addAttribute("customer", customerCreated);
        return "redirect:/";
    }
}
