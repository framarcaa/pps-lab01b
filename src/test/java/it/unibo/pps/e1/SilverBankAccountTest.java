package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest {

    public static final int BASE_AMOUNT = 1000;
    public static final int FEE = 1;
    private SilverBankAccount account;

    @BeforeEach
    void init(){
        CoreBankAccount base = new CoreBankAccount(fee -> FEE);
        this.account = new SilverBankAccount(base);
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
        assertEquals(BASE_AMOUNT - withdrawAmount - FEE, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(BASE_AMOUNT);
        int withdrawAmount = 1200;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }

}
