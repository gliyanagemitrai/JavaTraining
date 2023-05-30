package com.banking.services;

import com.banking.controllers.requests.SaveAccountRequest;
import com.banking.models.Account;
import java.util.List;

public interface AccountService {

 public List<Account> findAccounts();

 public Account saveAccount(SaveAccountRequest account);

 Account findAccountByID(String accountNo);
}
