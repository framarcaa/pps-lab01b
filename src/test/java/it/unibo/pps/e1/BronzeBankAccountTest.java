package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends BankAccountTest {

    @BeforeEach
    void init(){
        this.account = new BronzeBankAccount(new CoreBankAccount(fee -> fee >= 100 ?  FEE : 0));
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 50, 950",
            "1000, 100, 899"
    })
    public void testCanWithdraw(final int balance, final int withdraw, final int result) {
        this.account.deposit(balance);
        this.account.withdraw(withdraw);
        assertEquals(result, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(BASE_AMOUNT);
        int withdrawAmount = 1600;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }
}
