package com.example.Split_Wise_application.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "splitwise_expenses")
public class Expense extends BaseModel{

    private double amount;

    private String description;

    @ManyToMany
    private List<User> participents;

    @OneToOne
    private Currency currency;

    @OneToMany
    List<ExpenseReceivingUser> receivingUsers;

    @OneToMany
    List<ExpensePayingUser> payingUsers;
}
