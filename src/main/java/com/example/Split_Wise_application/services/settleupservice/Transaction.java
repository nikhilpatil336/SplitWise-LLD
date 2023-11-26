package com.example.Split_Wise_application.services.settleupservice;

import com.example.Split_Wise_application.models.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Transaction {

    private User from;
    private User to;
    private double amount;
}
