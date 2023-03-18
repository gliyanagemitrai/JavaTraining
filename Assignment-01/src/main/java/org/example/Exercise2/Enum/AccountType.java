package org.example.Exercise2.Enum;

public enum AccountType {
    REGULAR(1, "Regular saving Account"), SUPER(2, "Super saving Account"), POWERBONUS(3, "Power bonus Account");
    public final int id;
    public final String name;
    AccountType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
