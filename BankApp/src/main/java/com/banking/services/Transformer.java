package com.banking.services;

import com.banking.controllers.requests.DepositRequest;
import com.banking.controllers.requests.SaveAccountRequest;
import com.banking.controllers.responses.AccountResponse;
import com.banking.controllers.responses.AccountsResponse;
import com.banking.controllers.responses.TransactionResponse;
import com.banking.controllers.responses.TransactionsResponse;
import com.banking.models.Account;
import com.banking.models.Transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.engine.transaction.jta.platform.internal.WebSphereExtendedJtaPlatform.TransactionManagerAdapter.TransactionAdapter;

public interface Transformer {

  static AccountsResponse createAccountsResponse(List<Account> accounts) {
    List<AccountResponse> response = new ArrayList<>();
    for (Account account : accounts) {
      response.add(createAccountResponse(account));
    }
    return AccountsResponse.builder().accounts(response).build();
  }

  static AccountResponse createAccountResponse(Account account) {
    return AccountResponse.builder()
        .accountNo(account.getAccountNo())
        .nic(account.getNic())
        .customerName(account.getCustomerName())
        .balance(account.getBalance()).accountType(account.getAccountType())
        .build();
  }

  static Account mapToDto(SaveAccountRequest request) {
    return Account.builder()
        .nic(request.getNic())
        .customerName(request.getCustomerName())
        .accountType(request.getAccountType())
        .balance(BigDecimal.ZERO)
        .build();
  }

  static Transaction depositRequestToDto(DepositRequest request) {
   return Transaction.builder()
       .type("deposit")
       .amount(request.getAmount())
       .date(new Date())
       .accountNo(request.getAccountNo()).build();
  }
  static Transaction withdrawalRequestToDto(DepositRequest request) {
    return Transaction.builder()
        .type("withdrawal")
        .amount(request.getAmount())
        .date(new Date())
        .accountNo(request.getAccountNo()).build();
  }

  static TransactionResponse createTransactionResponse(Transaction transaction) {
    return TransactionResponse.builder()
        .id(transaction.getId())
        .accountNo(transaction.getAccountNo())
        .amount(transaction.getAmount())
        .type(transaction.getType())
        .date(transaction.getDate())
        .build();
  }

  static TransactionsResponse createTransactionsResponse(List<Transaction> transactions) {
    List<TransactionResponse> response = new ArrayList<>();
    for (Transaction transaction: transactions){
      response.add(createTransactionResponse(transaction));
    }
   return TransactionsResponse.builder().transactions(response).build();
  }
}
