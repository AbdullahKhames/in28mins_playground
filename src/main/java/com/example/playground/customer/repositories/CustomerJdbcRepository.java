package com.example.playground.customer.repositories;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.playground.customer.models.Customer;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Profile("dev")
public class CustomerJdbcRepository implements CustomerRepository{
    //enables you to write queiries
    private final JdbcTemplate jdbcTemplate;
    
    private static final String INSERT_QUERY = "insert into Customer(id, name, address) values(?, ?, ?)";
    private static final String DELETE_QUERY = "delete from Customer where id = ?";
    private static final String SELECT_QUERY = "SELECT * from Customer where id = ?";
    public Customer save(Customer customer){
       jdbcTemplate.update(INSERT_QUERY, customer.getId(), customer.getName(), customer.getAddress());
       return customer;
    }
	@Override
	public void deleteById(Long id) {
		jdbcTemplate.update(DELETE_QUERY, id);
	}
	@Override
	public Optional<Customer>findById(Long id) {
		System.out.println(id);
		Customer customer = jdbcTemplate.queryForObject(
				// the query
				SELECT_QUERY,
				// the row mapper maps result set to bean!
				new BeanPropertyRowMapper<>(Customer.class),
				// the id to fetch from db
				id);
		System.out.println(customer);
		return Optional.ofNullable(customer);
	}

}
