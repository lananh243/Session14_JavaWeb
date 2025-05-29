package com.data.service;

import com.data.model.Transaction;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Service
public class TransactionService {

    public void addTransaction(HttpSession session, Transaction transaction) {
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
        session.setAttribute("transactions", transactions);
    }

    public void removeTransaction(HttpSession session, String description) {
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions != null) {
            for (Transaction transaction : transactions) {
                if (transaction.getDescription().equals(description)) {
                    transactions.remove(transaction);
                    break;
                }
            }
        }
        session.setAttribute("transactions", transactions);
    }

    public List<Transaction> getTransactions(HttpSession session) {
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        return transactions;
    }
}
