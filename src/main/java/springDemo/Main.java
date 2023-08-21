package springDemo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/*
 * @Configuration
 * 
 * @EnableAutoConfiguration
 * //telling Spring to look for components in given package.
 * 
 * @ComponentScan(basePackages = "springDemo")
 */

@RestController
@RequestMapping("api/v1/customers")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // expressed as endpoints that clients can call--->>
    // for this to work, class should have annotation of RestController-->>
    // it is path provided of a class to get "Hello" msg---->>
    @GetMapping("/greet")
    public greetResponse greet() {
        greetResponse response = new greetResponse("Hello",
                List.of("Java", "HTML", "CSS", "JavaScript", "Spring"),
                new Person("John", 30, 40000));
        return response;
    }

    record Person(String name, int age, double savings) {
    }

    record greetResponse(String greet,
            List<String> favProgrammingLanguages, Person person) {
    }
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

    @GetMapping()
    public List<Customer> getCustomer() {
        return List.of();
    }

}
