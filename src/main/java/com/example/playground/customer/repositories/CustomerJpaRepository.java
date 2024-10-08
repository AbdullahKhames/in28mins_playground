package com.example.playground.customer.repositories;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.playground.customer.models.Customer;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Profile("prod")
@Transactional
public class CustomerJpaRepository implements CustomerRepository {
    private final EntityManager entityManager;
    @Override
    public Customer save(Customer customer) {
        return entityManager.merge(customer);
    }
	@Override
	public void deleteById(Long id) {
		Customer customer = entityManager.find(Customer.class, id);
		if (customer != null) {
			entityManager.remove(customer);
		}
	}
	@Override
	public Optional<Customer> findById(Long id) {
		return Optional.ofNullable(entityManager.find(Customer.class, id));
	}
}
