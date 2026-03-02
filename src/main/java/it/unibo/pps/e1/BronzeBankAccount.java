package it.unibo.pps.e1;

import java.util.function.Function;

public class BronzeBankAccount implements BankAccount {
    private final CoreBankAccount base;

    public BronzeBankAccount(CoreBankAccount base) {
        this.base = base;
    }

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() <= amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
