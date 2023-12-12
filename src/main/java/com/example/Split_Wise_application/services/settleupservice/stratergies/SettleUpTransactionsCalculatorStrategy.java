package com.example.Split_Wise_application.services.settleupservice.stratergies;

import com.example.Split_Wise_application.models.Expense;
import com.example.Split_Wise_application.models.ExpensePayingUser;
import com.example.Split_Wise_application.models.ExpenseReceivingUser;
import com.example.Split_Wise_application.services.settleupservice.Transaction;

import java.util.List;

public interface SettleUpTransactionsCalculatorStrategy {

    List<Transaction> getTransaction(List<ExpensePayingUser> expensePayingUsers, List<ExpenseReceivingUser> expenseReceivingUsers);
}
