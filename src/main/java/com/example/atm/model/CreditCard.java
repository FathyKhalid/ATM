package com.example.atm.model;

import java.util.Random;

public class CreditCard {
    private final String creditNumber;
    private String pin;
    private double balance;

    public CreditCard()
    {
        creditNumber = generate();
        Random random = new Random();
        pin = String.format("%04d", random.nextInt(10000));
    }

    private Random random = new Random(System.currentTimeMillis());
    private String generate() {
        int randomNumberLength = 16 - ("5412".length() + 1);

        StringBuilder builder = new StringBuilder("5412");
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = this.random.nextInt(10);
            builder.append(digit);
        }
        int checkDigit = this.getCheckDigit(builder.toString());
        builder.append(checkDigit);

        return builder.toString();
    }
    private int getCheckDigit(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }
        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }

    public void Withdraw(double amount)
    {
        balance += amount;
    }
    public void Deposit(double amount)
    {
        balance -= amount;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
