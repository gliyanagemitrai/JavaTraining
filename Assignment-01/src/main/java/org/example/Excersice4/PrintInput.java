package org.example.Excersice4;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrintInput {
    public static void main(String[] args) {
        String hello = "hello world";
        Map<Character, Integer> map = new LinkedHashMap<>();
        hello = hello.replaceAll("\\s+", "");
        for (int x = 0; x < hello.length(); x++) {
            int freq = map.getOrDefault(hello.charAt(x), 0);
            map.put(hello.charAt(x), ++freq);
        }
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  : " + entry.getValue());
        }
    }
}
