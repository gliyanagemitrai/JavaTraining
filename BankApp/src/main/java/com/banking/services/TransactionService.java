package com.banking.services;


import com.banking.controllers.requests.DepositRequest;
import com.banking.exception.AccountNotFoundException;
import com.banking.models.Account;
import com.banking.models.Transaction;
import com.banking.repository.AccountRepository;
import com.banking.repository.TransactionRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

  @Autowired
  AccountService accountService;
  @Autowired
  TransactionRepository transactionRepository;
  @Autowired
  AccountRepository accountRepository;
  public Transaction deposit(DepositRequest request) {
    Account account = accountService.findAccountByID(request.getAccountNo());
    Transaction result = transactionRepository.save( Transformer.depositRequestToDto(request));
    BigDecimal balance =  account.getBalance().add(request.getAmount());
    account.setBalance(balance);
    accountRepository.save(account);
   return result;
  }

  public Transaction withdrawal(DepositRequest request) {
    Account account = accountService.findAccountByID(request.getAccountNo());

    if (account.getBalance().compareTo(request.getAmount()) <= 0) {
      throw new AccountNotFoundException("balance is not enough", "balance is not enough",
          HttpStatus.UNPROCESSABLE_ENTITY);
    }
    Transaction result = transactionRepository.save( Transformer.withdrawalRequestToDto(request));
    BigDecimal balance =  account.getBalance().subtract(request.getAmount());
    account.setBalance(balance);
    accountRepository.save(account);
    return result;
  }

  public List<Transaction> findByAccountNo(String accountNo) {
    Account account = accountService.findAccountByID(accountNo);
    return  transactionRepository.findByAccountNo(account.getAccountNo());
  }


}
