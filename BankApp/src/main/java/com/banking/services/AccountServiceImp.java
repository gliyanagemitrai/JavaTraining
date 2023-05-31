package com.banking.services;

import com.banking.controllers.requests.SaveAccountRequest;
import com.banking.exception.AccountNotFoundException;
import com.banking.models.Account;
import com.banking.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

  @Autowired
  AccountRepository accountRepository;

  @Override
  public List<Account> findAccounts() {
    return accountRepository.findAll();
  }

  public List<Account> findByAccountNo(String accountNo) {
    return accountRepository.findByAccountNo(accountNo);
  }

  public Account saveAccount(SaveAccountRequest request) {
    Account account = Transformer.mapToDto(request);
    String accountNo = null;
    List<Account> accounts = new ArrayList<>();
    while (true) {
      accountNo = Account.createAccountNo();
      accounts = accountRepository.findByAccountNo(accountNo);
      if (accounts.size() == 0) {
        break;
      }
    }

    account.setAccountNo(Account.createAccountNo());
    return accountRepository.save(account);
  }

  @Override
  public Account findAccountByID(String accountNo) {
    Account account = accountRepository.findById(accountNo).orElse(null);
    if (Objects.isNull(account)) {
      throw new AccountNotFoundException("account not found", "account not found",
          HttpStatus.UNPROCESSABLE_ENTITY);
    }

    accountRepository.findAll(PageRequest.of(0,10));
    return account;

  }

  @Override
  public Page<Account> findAccounts(Pageable pageable, String search) {
    ExampleMatcher matcher = ExampleMatcher.matchingAny()
        .withMatcher("accountNo", ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase());
    Example<Account> filter = Example.of(Account.builder().accountNo(search).build(),matcher);
    return accountRepository.findAll(filter,pageable);
  }


}
