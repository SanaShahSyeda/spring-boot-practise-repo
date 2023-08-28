package springDemo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// could perform CRUD operations
public interface CustomerRepository extends
                JpaRepository<Customer, Integer> {

        @Override
        List<Customer> findAll();

}
