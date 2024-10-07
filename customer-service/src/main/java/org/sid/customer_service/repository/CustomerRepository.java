package org.sid.customer_service.repository;

import org.sid.customer_service.entities.Customer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
