package com.banking.controllers;


import com.banking.controllers.requests.SaveAccountRequest;
import com.banking.controllers.responses.AccountResponse;
import com.banking.controllers.responses.AccountsResponse;
import com.banking.models.Account;
import com.banking.services.AccountService;
import com.banking.services.Transformer;
import com.banking.services.ValidationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  @Autowired
  AccountService accountService;
  @Autowired
  ValidationService validationService;


  @GetMapping(value = "")
  AccountsResponse findAllAccount() {
    return Transformer.createAccountsResponse(accountService.findAccounts());

  }

//  @RequestMapping("test/{accountNo}")
//  public Account showUserForm(@PathVariable("accountNo") Account account) {
//    return  account;
//  }
  @GetMapping(value = "/{accountNo}")
  AccountResponse findAccount(@PathVariable String accountNo ) {
    return Transformer.createAccountResponse(accountService.findAccountByID(accountNo));
  }

  @PostMapping(value = "")
  Account saveAccount(@Valid @RequestBody SaveAccountRequest request, BindingResult result)
      throws JsonProcessingException {
    validationService.validate(result);
    return accountService.saveAccount(request);
  }
}
