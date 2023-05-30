package com.banking.repository;

import com.banking.models.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

  List<Transaction> findByAccountNo(String accountNo);
}
