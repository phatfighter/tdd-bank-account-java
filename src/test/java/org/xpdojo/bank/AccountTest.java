package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void testNewAccountHasZeroBalance() {
        Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void testDepositOnceToAccountIncreasesBalance() {
        Account account = new Account();
        account.depositMoney(100);
        assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    public void testDepositTwiceToAccountIncreasesBalance() {
        Account account = new Account();
        account.depositMoney(100);
        assertThat(account.getBalance()).isEqualTo(100);
        account.depositMoney(200);
        assertThat(account.getBalance()).isEqualTo(300);
    }

    @Test
    public void testWithdrawFromAccountDecreasesBalance() throws IOException {
        Account account = new Account();
        account.depositMoney(100);
        assertThat(account.getBalance()).isEqualTo(100);
        account.withdrawMoney(40);
        assertThat(account.getBalance()).isEqualTo(60);
    }

    @Test
    public void testWithdrawMoreThanBalanceThrowsException() throws IOException {
        Account account = new Account();
        Throwable exception = assertThrows(IOException.class, () -> account.withdrawMoney(10));
        assertEquals("Can't withdraw that amount", exception.getMessage());
    }
}
