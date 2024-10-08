package com.example.playground.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.playground.customer.models.Customer;
import com.example.playground.customer.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CustomerCommandLineRunner implements CommandLineRunner {
 
	private final CustomerRepository customerRepository;
	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer(1L, "default", "default"));
	}

}
