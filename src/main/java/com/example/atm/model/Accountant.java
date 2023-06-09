package com.example.atm.model;

import java.time.LocalDate;

public class Accountant {
    public static int id;
    private String fullName;
    private LocalDate birthDate;
    private String postalCode;
    private CreditCard creditCard = new CreditCard();

    public Accountant(){
        id +=1;
    }
    public Accountant(String fullName, LocalDate birthDate, String postalCode) {

        id += 1;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.postalCode = postalCode;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public int getId() {
        return id;
    }
}
