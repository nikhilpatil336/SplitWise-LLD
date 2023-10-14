package com.example.Split_Wise_application.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "splitwise_expenses_receiving_users")
public class ExpenseReceivingUser extends BaseModel{

    private double amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;
}
