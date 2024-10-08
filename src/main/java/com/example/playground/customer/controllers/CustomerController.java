package com.example.playground.customer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.playground.customer.models.Customer;
import com.example.playground.customer.services.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    private ResponseEntity<Customer> insert(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }
    
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
    	customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Customer> select(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.select(id), HttpStatus.OK);
    }
}
