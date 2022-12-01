package com.miguelgarcia.bancobaseapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miguelgarcia.bancobaseapi.dto.ExpenseProjection;
import com.miguelgarcia.bancobaseapi.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAccountsByCustomerId(Long id);

    @Query(nativeQuery = true, value = "SELECT e.id AS id, tc.code AS code, tc.name AS name, e.total AS total FROM (SELECT t.category_id AS id , SUM(t.amount) AS total FROM `transaction` t WHERE account_id = :accountId GROUP BY t.category_id) AS e INNER JOIN transaction_category tc ON e.id = tc.id")
    List<ExpenseProjection> findExpensesByCategory(@Param("accountId") long accountId);
}
