package org.xpdojo.bank;

public class Account {

    private double balance = 0;

    public double getBalance()  {
        return balance;
    }

    public void depositMoney(double amount) {
        balance += amount;
    }
}
