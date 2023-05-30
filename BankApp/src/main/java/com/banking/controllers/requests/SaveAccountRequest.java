package com.banking.controllers.requests;

import com.banking.constraint.In;
import com.banking.models.AccountType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class
SaveAccountRequest {
//  String accountNo;
  @NotBlank
  String customerName;

  @NotBlank
  String nic;


  @In(acceptedValues = {"TYPE1", "TYPE2", "TYPE3"})
  public String accountType;
}
