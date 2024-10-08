package com.example.playground.customer.services;

import org.springframework.stereotype.Service;

import com.example.playground.customer.models.Customer;
import com.example.playground.customer.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public Customer save(Customer customer) {
    	return customerRepository.save(customer);
    }
	public void delete(Long id) {
		customerRepository.deleteById(id);
		
	}
	public Customer select(Long id) {
		return customerRepository.findById(id).orElse(null);
		
	}
}
