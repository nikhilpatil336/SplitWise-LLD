package com.example.Split_Wise_application.controllers.settleupcontroller.RequestDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SettleUpGroupRequestDTO {

    private int userId;

    private int groupId;
}
