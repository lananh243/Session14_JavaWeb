package com.data.controller;

import com.data.model.Transaction;
import com.data.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction")
    public String transactionForm(){
        return "transaction";
    }

    @GetMapping("list-transaction")
    public String listTransaction(HttpSession session, Model model){
        List<Transaction> transactions = transactionService.getTransactions(session);
        model.addAttribute("transactions", transactions);
        return "list_transaction";
    }

    @PostMapping("/add-transaction")
    public String addTransaction(HttpSession session, Transaction transaction){
        transactionService.addTransaction(session, transaction);
        return "redirect:/list-transaction";
    }

    @GetMapping("/delete-transaction/{description}")
    public String deleteTransaction(HttpSession session, @PathVariable String description){
        transactionService.removeTransaction(session, description);
        return "redirect:/list-transaction";
    }
}
