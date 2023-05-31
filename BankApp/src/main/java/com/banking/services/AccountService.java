package com.banking.services;

import com.banking.controllers.requests.SaveAccountRequest;
import com.banking.models.Account;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {

 public List<Account> findAccounts();

 public Account saveAccount(SaveAccountRequest account);

 Account findAccountByID(String accountNo);


 Page<Account> findAccounts(Pageable pageable, String search);

}
