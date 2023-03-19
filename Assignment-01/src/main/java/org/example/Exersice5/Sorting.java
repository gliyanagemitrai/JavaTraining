package org.example.Exersice5;

import java.util.*;

public class Sorting {
    public  static  void  main(String[] args){
        Set<String> names  = new TreeSet<>();
        names.addAll(Arrays.asList("Baasd","asdasd","f","Bb","casdasd","AA","sdasdsd","B","Aac"));

        for (String name:names
             ) {
            System.out.println(name);
        }
    }
}
