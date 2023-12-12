package com.example.Split_Wise_application.services.settleupservice.settleupserviceimpl;

import com.example.Split_Wise_application.models.*;
import com.example.Split_Wise_application.services.settleupservice.SettleUpService;
import com.example.Split_Wise_application.services.settleupservice.Transaction;
import com.example.Split_Wise_application.services.settleupservice.stratergies.SettleUpTransactionsCalculatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettleUpServiceImpl implements SettleUpService {

    @Autowired
    private SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy;

    @Override
    public List<Transaction> settleUpGroup(Group group) {

        List<Expense> expenses = group.getExpenses();

        List<ExpensePayingUser> expensePayingUsers = new ArrayList<>();

        List<ExpenseReceivingUser> expenseReceivingUsers = new ArrayList<>();

        for(Expense expense : expenses)
            expensePayingUsers.addAll(expense.getPayingUsers());

        for(Expense expense : expenses)
            expenseReceivingUsers.addAll(expense.getReceivingUsers());

        return settleUpTransactionsCalculatorStrategy.getTransaction(expensePayingUsers, expenseReceivingUsers);
    }

    @Override
    public Transaction settleUpUser(User user) {
        return null;
    }
}
