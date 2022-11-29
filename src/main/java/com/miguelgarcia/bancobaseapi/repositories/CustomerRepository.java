package com.miguelgarcia.bancobaseapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miguelgarcia.bancobaseapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
