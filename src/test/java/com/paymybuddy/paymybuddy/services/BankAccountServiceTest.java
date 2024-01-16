package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.BankAccount;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.BankAccountRepository;
import com.paymybuddy.paymybuddy.services.BankAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BankAccountServiceTest {

    @Mock
    private BankAccountRepository bankAccountRepository;

    private BankAccountService bankAccountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        bankAccountService = new BankAccountService(bankAccountRepository);
    }

    @Test
    public void testCreateBankAccount() {
        BankAccount account = new BankAccount();
        User user = new User();
        account.setAccountNumber("Bank");
        account.setIban("FR76 3000 1007 1600 0000 0000 123");
        account.setUser(user);

        when(bankAccountRepository.save(account)).thenReturn(account);

        BankAccount result = bankAccountService.createBankAccount(account);

        assertEquals(account, result);
        verify(bankAccountRepository, times(1)).save(account);
    }
}