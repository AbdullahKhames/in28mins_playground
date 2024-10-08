package com.example.playground.customer.repositories;

import java.util.Optional;

import com.example.playground.customer.models.Customer;

public interface CustomerRepository {
	Customer save(Customer customer);
    void deleteById(Long id);
	Optional<Customer> findById(Long id);
}
