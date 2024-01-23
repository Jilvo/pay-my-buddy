package com.paymybuddy.paymybuddy.services;

import com.paymybuddy.paymybuddy.models.Transaction;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.repositories.TransactionRepository;
import com.paymybuddy.paymybuddy.services.TransactionService;
import com.paymybuddy.paymybuddy.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private UserService userService;

    private TransactionService transactionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        transactionService = new TransactionService(transactionRepository, userService);
    }

    @Test
    public void testGetAllTransactions() {
        Transaction transaction1 = new Transaction();
        Transaction transaction2 = new Transaction();
        when(transactionRepository.findAll()).thenReturn(Arrays.asList(transaction1, transaction2));

        List<Transaction> result = transactionService.getAllTransactions();

        assertEquals(2, result.size());
        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    public void testGetTransactionsByUserId() {
        Transaction transaction = new Transaction();
        when(transactionRepository.findBySenderUser_Id(1)).thenReturn(Arrays.asList(transaction));

        List<Transaction> result = transactionService.getTransactionsByUserId(1);

        assertEquals(1, result.size());
        verify(transactionRepository, times(1)).findBySenderUser_Id(1);
    }

    @Test
    public void testCreateTransaction() {
        Transaction transaction = new Transaction();
        User senderUser = new User();
        User receiverFriend = new User();
        transaction.setDescription("Transaction description");
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setDate(null);
        transaction.setSender_user(senderUser);
        transaction.setReceiver_user(receiverFriend);

        transactionService.createTransaction(transaction);

        assertEquals("Transaction description", transaction.getDescription());
        assertEquals(new BigDecimal("100.00"), transaction.getAmount());
        assertNull(transaction.getDate());
        assertEquals(senderUser, transaction.getSender_user());
        assertEquals(receiverFriend, transaction.getReceiver_user());


        verify(transactionRepository, times(1)).save(transaction);
    }
}