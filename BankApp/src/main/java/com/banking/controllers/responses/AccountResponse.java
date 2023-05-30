package com.banking.controllers.responses;

import com.banking.models.AccountType;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
  String accountNo;
  String customerName;
  String nic;
  BigDecimal balance;
  String accountType;
}
