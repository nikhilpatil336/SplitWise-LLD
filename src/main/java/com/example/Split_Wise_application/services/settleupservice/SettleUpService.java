package com.example.Split_Wise_application.services.settleupservice;

import com.example.Split_Wise_application.models.Group;
import com.example.Split_Wise_application.models.User;

import java.util.List;

public interface SettleUpService {

    List<Transaction> settleUpGroup (Group group);

    Transaction settleUpUser (User user);
}
