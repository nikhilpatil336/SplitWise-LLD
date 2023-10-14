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

//    @ManyToOne
//    private User createdBy;

    @ManyToMany
    private List<User> participents;

    @OneToOne
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ElementCollection
    @CollectionTable(name = "payer", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyClass(User.class)
    @Column(name = "amount")
    private Map<User, Double> payer;

    @ElementCollection
    @CollectionTable(name = "receiver", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyClass(User.class)
    @Column(name = "amount")
    private Map<User, Double> Receiver;
}
