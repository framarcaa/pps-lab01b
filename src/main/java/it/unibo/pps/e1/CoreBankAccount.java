package it.unibo.pps.e1;

import java.util.function.Function;

public class CoreBankAccount implements BankAccount{

    private int balance = 0;
    private final Function<Integer,Integer> fee;

    public CoreBankAccount(Function<Integer,Integer> fee) {
        this.fee = fee;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(int amount) {
        this.balance = this.balance - amount - this.fee.apply(amount);
    }
}
