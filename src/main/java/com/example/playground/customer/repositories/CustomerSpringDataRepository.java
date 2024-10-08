package com.example.playground.customer.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.playground.customer.models.Customer;

@Profile("springData")
@Repository
public interface CustomerSpringDataRepository extends JpaRepository<Customer, Long>, CustomerRepository {

}
