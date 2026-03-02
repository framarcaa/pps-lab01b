package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest {

    public static final int BASE_AMOUNT = 1000;
    private GoldBankAccount account;

    @BeforeEach
    void init(){
        CoreBankAccount base = new CoreBankAccount(fee -> 0);
        this.account = new GoldBankAccount(base);
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(BASE_AMOUNT);
        assertEquals(BASE_AMOUNT, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(BASE_AMOUNT);
        int withdrawAmount = 200;
        this.account.withdraw(withdrawAmount);
        assertEquals(BASE_AMOUNT - withdrawAmount, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(BASE_AMOUNT);
        int withdrawAmount = 1600;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }

    @Test
    public void testCanWithdrawMoreThanActualBalace() {
        this.account.deposit(BASE_AMOUNT);
        int withdrawAmount = 1200;
        this.account.withdraw(withdrawAmount);
        assertEquals(BASE_AMOUNT - withdrawAmount, this.account.getBalance());
    }

}
