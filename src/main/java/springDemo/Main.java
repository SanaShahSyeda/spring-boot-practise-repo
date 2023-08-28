package springDemo;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // expressed as endpoints that clients can call--->>
    // for this to work, class should have annotation of RestController-->>
    // it is path provided of a class to get "Hello" msg---->>

    // @GetMapping("/greet")
    // public greetResponse greet() {
    // greetResponse response = new greetResponse("Hello",
    // List.of("Java", "HTML", "CSS", "JavaScript", "Spring", "Spring boot"),
    // new Person("John", 30, 40000));
    // return response;
    // }

    // record Person(String name, int age, double savings) {
    // }

    // record greetResponse(String greet,
    // List<String> favProgrammingLanguages, Person person) {
    // }
    // this record line is equivalent to greetResponse class---->>
    // class greetResponse {
    // private final String greet;
    // greetResponse(String greet) {
    // this.greet = greet;
    // }
    // public String getGreet() {
    // return greet;
    // }
    // }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age) {
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer(null, null, null, null);
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(null);
    }
}
