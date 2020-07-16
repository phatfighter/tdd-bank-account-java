package org.xpdojo.bank;

import java.io.IOException;

public class Account {

    private double balance = 0;

    public double getBalance()  {
        return balance;
    }

    public void depositMoney(double amount) {
        balance += amount;
    }

    public void withdrawMoney(double amount) throws IOException {
        if (amount > balance) throw new IOException("Can't withdraw that amount");
        balance -= amount;
    }
}
