package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest {

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount(fee -> FEE));
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
