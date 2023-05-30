package com.banking.repository;

import com.banking.models.Account;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String >,
    PagingAndSortingRepository<Account,String>, CrudRepository<Account,String >{
  List<Account> findByAccountNo(String accountNo);

}
