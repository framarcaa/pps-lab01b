package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    protected static final int BASE_AMOUNT = 1000;
    protected static final int FEE = 1;
    protected static final int INITIAL_BALANCE = 0;
    protected BankAccount account;

    @BeforeEach
    void init(){
        this.account = new CoreBankAccount(fee -> FEE);
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(INITIAL_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(BASE_AMOUNT);
        assertEquals(BASE_AMOUNT, this.account.getBalance());
    }
}
