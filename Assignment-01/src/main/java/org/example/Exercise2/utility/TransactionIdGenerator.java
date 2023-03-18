package org.example.Exercise2.utility;

import java.util.Random;

public class TransactionIdGenerator {
   public String createId(){

       Random rand = new Random();
       String num = "T";
       for (int i = 0; i < 14; i++)
       {
           int n = rand.nextInt(10) + 0;
           num += Integer.toString(n);
       }
       return num;
    }
}
