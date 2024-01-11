package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TransactionService.class, UserService.class})
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private UserService userService;
    @Autowired
    private       TestEntityManager testEntityManager;

    @Test
    public void injectedComponentsAreRightlySetUp() {

        Assertions.assertNotNull(testEntityManager);
        Assertions.assertNotNull(transactionService);
        Assertions.assertNotNull(userService);
    }

    @Test
    public void getAllTransactionsTest() {
        Transaction transaction = new Transaction("Refund", new BigDecimal("57.00"),  new User(), new User());
        transactionRepository.save(transaction);
        Assertions.assertFalse(transactionService.getAllTransactions().isEmpty());
    }

    @Test
    public void getTransactionsByUserIdTest() {
        Transaction transaction = new Transaction("Refund", new BigDecimal("57.00"),  new User(), new User());
        transactionRepository.save(transaction);
        List<Transaction> transactions = transactionService.getTransactionsByUserId(1);

        Assertions.assertFalse(transactions.isEmpty());
    }

    @Test
    public void createTransactionTest() {
        Transaction transaction = new Transaction("Refund", new BigDecimal("57.00"),  new User(), new User());
        transactionRepository.save(transaction);
        Assertions.assertFalse(transactionService.getAllTransactions().isEmpty());
    }
}