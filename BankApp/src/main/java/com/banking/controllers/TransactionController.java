package com.banking.controllers;

import com.banking.controllers.requests.DepositRequest;
import com.banking.controllers.responses.TransactionResponse;
import com.banking.controllers.responses.TransactionsResponse;
import com.banking.models.Transaction;
import com.banking.services.AccountService;
import com.banking.services.TransactionService;
import com.banking.services.Transformer;
import com.banking.services.ValidationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import java.util.List;
import javax.xml.crypto.dsig.TransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

  @Autowired
  ValidationService validationService;

  @Autowired
  AccountService accountService;

  @Autowired
  TransactionService transactionService;

  @PostMapping("/deposit")
  public TransactionResponse deposit(@Valid @RequestBody DepositRequest request, BindingResult result)
      throws JsonProcessingException {
    ValidationService.validate(result);

    Transaction transaction = transactionService.deposit(request);

    return Transformer.createTransactionResponse(transaction);
  }

  @PostMapping("/withdrawal")
  public TransactionResponse withdrawal(@Valid @RequestBody DepositRequest request, BindingResult result)
      throws JsonProcessingException {
    ValidationService.validate(result);
    return Transformer.createTransactionResponse( transactionService.withdrawal(request));
  }


  @GetMapping("/history/{accountNo}")
  public TransactionsResponse history(@PathVariable String accountNo) {
    return  Transformer.createTransactionsResponse(transactionService.findByAccountNo(accountNo));
  }
}
