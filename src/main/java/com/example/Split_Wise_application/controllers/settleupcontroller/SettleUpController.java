package com.example.Split_Wise_application.controllers.settleupcontroller;

import com.example.Split_Wise_application.controllers.settleupcontroller.RequestDTO.SettleUpGroupRequestDTO;
import com.example.Split_Wise_application.controllers.settleupcontroller.RequestDTO.SettleUpUserRequestDTO;
import com.example.Split_Wise_application.controllers.settleupcontroller.ResponseDTO.SettleUpGroupResponseDTO;
import com.example.Split_Wise_application.controllers.settleupcontroller.ResponseDTO.SettleUpUserResponseDTO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettleUpController {

    public SettleUpUserResponseDTO settleUser(SettleUpUserRequestDTO settleUpUserRequestDTO) {
        return null;
    }

    public SettleUpGroupResponseDTO settleGroup(SettleUpGroupRequestDTO settleUpGroupRequestDTO) {
        return null;
    }
}
