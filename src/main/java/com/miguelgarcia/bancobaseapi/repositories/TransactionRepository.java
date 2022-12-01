package com.miguelgarcia.bancobaseapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miguelgarcia.bancobaseapi.model.Account;

@Repository
public interface TransactionRepository extends JpaRepository<Account, Long> {
}
