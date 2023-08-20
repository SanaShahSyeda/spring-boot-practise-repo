package springDemo;

import org.springframework.data.jpa.repository.JpaRepository;

// could perform CRUD operations
public interface CustomerRepository extends
        JpaRepository<Customer, Integer> {

}
