package com.example.Split_Wise_application.controllers.settleupcontroller;

import com.example.Split_Wise_application.controllers.settleupcontroller.RequestDTO.SettleUpGroupRequestDTO;
import com.example.Split_Wise_application.controllers.settleupcontroller.RequestDTO.SettleUpUserRequestDTO;
import com.example.Split_Wise_application.controllers.settleupcontroller.ResponseDTO.SettleUpGroupResponseDTO;
import com.example.Split_Wise_application.controllers.settleupcontroller.ResponseDTO.SettleUpUserResponseDTO;
import com.example.Split_Wise_application.models.Group;
import com.example.Split_Wise_application.models.User;
import com.example.Split_Wise_application.repositories.GroupRepository;
import com.example.Split_Wise_application.repositories.UserRepository;
import com.example.Split_Wise_application.services.settleupservice.SettleUpService;
import com.example.Split_Wise_application.services.settleupservice.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettleUpController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettleUpService settleUpService;

    @Autowired
    private ModelMapper modelMapper;


    public ResponseEntity<SettleUpGroupResponseDTO> settleGroup(SettleUpGroupRequestDTO settleUpGroupRequestDTO) {
        Group savedGroup = groupRepository.findById(settleUpGroupRequestDTO.getGroupId()).orElseThrow(()-> new RuntimeException("group not found."));
        User savedUser = userRepository.findById(settleUpGroupRequestDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        List<User> users = savedGroup.getMembers();

        List<Transaction> transactions = null;

        if(users.contains(savedUser))
            transactions = settleUpService.settleUpGroup(savedGroup);

        else
            throw new RuntimeException("User does not delong in this group");

        return ResponseEntity.ok(modelMapper.map(transactions, SettleUpGroupResponseDTO.class));
    }

    public ResponseEntity<Transaction> settleUser(SettleUpUserRequestDTO settleUpUserRequestDTO)
    {
        User savedUser = userRepository.findById(settleUpUserRequestDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        return null;
    }
}
