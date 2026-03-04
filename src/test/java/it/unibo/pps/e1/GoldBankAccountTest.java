package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BankAccountTest {

    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(new CoreBankAccount(fee -> 0));
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(BASE_AMOUNT);
        int withdrawAmount = 200;
        this.account.withdraw(withdrawAmount);
        assertEquals(BASE_AMOUNT - withdrawAmount, this.account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 200, 800",
            "1000, 1400, -400"
    })
    public void testCanWithdraw(final int balance, final int withdraw, final int result) {
        this.account.deposit(balance);
        this.account.withdraw(withdraw);
        assertEquals(result, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanOverdraft(){
        this.account.deposit(BASE_AMOUNT);
        int withdrawAmount = 1600;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }
}
