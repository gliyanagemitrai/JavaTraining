package com.banking.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "accounts")
public class Account {

  @Id
  String accountNo;
  String customerName;
  String nic;
  String accountType;

  @Column(nullable = false, columnDefinition = "DECIMAL(10,2) DEFAULT '0.00'")
  private BigDecimal balance  ;

   public static String createAccountNo(){
    Random rand = new Random();
    String card = "AC";
    for (int i = 0; i < 14; i++)
    {
      int n = rand.nextInt(10) + 0;
      card += Integer.toString(n);
    }
    return  card;
  }


}
