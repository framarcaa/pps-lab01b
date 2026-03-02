package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {
    private CoreBankAccount base;

    public GoldBankAccount(CoreBankAccount base) {
        this.base = base;
    }

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        int OVERDRAFT = 500;
        if (this.getBalance() + OVERDRAFT <= amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
