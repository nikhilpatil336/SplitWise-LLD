package com.example.Split_Wise_application.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "splitwise_users")
public class User extends BaseModel{

    private String name;

    private int phoneNumber;

    private String password;

    @ManyToMany
    private List<Group> groups;

    @ManyToMany
    private List<Expense> expenses;
}
