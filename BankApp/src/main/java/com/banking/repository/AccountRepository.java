package com.banking.repository;

import com.banking.models.Account;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String >,
    QueryByExampleExecutor<Account> {
  List<Account> findByAccountNo(String accountNo);

  Page<Account> findAll(Example example, Pageable pageable);

  Page<Account> findAll(Pageable pageable);

}
