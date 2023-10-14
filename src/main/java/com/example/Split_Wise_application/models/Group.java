package com.example.Split_Wise_application.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "splitwise_groups")
public class Group extends BaseModel{

    private String name;

//    @ManyToOne
//    private User createdBy;

    @ManyToMany
    private List<User> admins;

    @ManyToMany
    private List<User> members;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Expense> expenses;
}
