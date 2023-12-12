package com.example.Split_Wise_application.services.settleupservice.stratergies;

import com.example.Split_Wise_application.models.ExpensePayingUser;
import com.example.Split_Wise_application.models.ExpenseReceivingUser;
import com.example.Split_Wise_application.models.User;
import com.example.Split_Wise_application.services.settleupservice.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GiveToNextSettleUpTransactionsCalculatorStrategy implements SettleUpTransactionsCalculatorStrategy {
    @Override
    public List<Transaction> getTransaction(List<ExpensePayingUser> expensePayingUsers
            , List<ExpenseReceivingUser> expenseReceivingUsers) {

        Map<User, Double> extraAmount = new HashMap<>();

        for(ExpenseReceivingUser expenseReceivingUser : expenseReceivingUsers) {
            if(extraAmount.containsKey(expenseReceivingUser.getUser())) {
                extraAmount.put(expenseReceivingUser.getUser(), extraAmount.get(expenseReceivingUser.getUser()) + expenseReceivingUser.getAmount());
            } else {
                extraAmount.put(expenseReceivingUser.getUser(), expenseReceivingUser.getAmount());
            }
        }

        for(ExpensePayingUser expensePayingUser : expensePayingUsers) {
            if(extraAmount.containsKey(expensePayingUser.getUser())) {
                extraAmount.put(expensePayingUser.getUser(), extraAmount.get(expensePayingUser.getUser()) - expensePayingUser.getAmount());
            }
            else {
                extraAmount.put(expensePayingUser.getUser(), expensePayingUser.getAmount());
            }
        }

        List<Transaction> answer = new ArrayList<>();

        List<Map.Entry<User, Double>> extraAmountList = new ArrayList<>(extraAmount.entrySet());// <User, Double>

        for(int i = 0; i < extraAmountList.size()-1; i++)
        {
            Transaction transaction = new Transaction();
            if(extraAmountList.get(i).getValue() > 0) //have paid extra
            {
                transaction.setFrom(extraAmountList.get(i+1).getKey());
                transaction.setTo(extraAmountList.get(i).getKey());
                transaction.setAmount(Math.abs(extraAmountList.get(i).getValue()));

                extraAmountList.get(i+1).setValue(extraAmountList.get(i+1).getValue() + Math.abs(extraAmountList.get(i).getValue()));
            }

            else if(extraAmountList.get(i).getValue() < 0) //have paid less
            {
                transaction.setFrom(extraAmountList.get(i).getKey());
                transaction.setTo(extraAmountList.get(i+1).getKey());
                transaction.setAmount(Math.abs(extraAmountList.get(i).getValue()));

                extraAmountList.get(i+1).setValue(extraAmountList.get(i+1).getValue() - Math.abs(extraAmountList.get(i).getValue()));
            }

            answer.add(transaction);
        }
    
        return answer;
    }
}
