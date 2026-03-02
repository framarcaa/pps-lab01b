package it.unibo.pps.e1;

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
        int fee = amount < 100 ? 0 : 1;
        if (this.getBalance() <= amount + fee){
            throw new IllegalStateException();
        }
        base.withdraw(amount + fee);
    }
}
