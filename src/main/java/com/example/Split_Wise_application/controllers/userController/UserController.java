package com.example.Split_Wise_application.controllers.userController;

import com.example.Split_Wise_application.Services.UserService;
import com.example.Split_Wise_application.controllers.userController.RequestDTO.CreateUserRequestDTO;
import com.example.Split_Wise_application.controllers.userController.RequestDTO.UpdateUserRequestDTO;
import com.example.Split_Wise_application.controllers.userController.ResponseDTO.CreateUserResponseDTO;
import com.example.Split_Wise_application.controllers.userController.ResponseDTO.GetUserByIdResponseDTO;
import com.example.Split_Wise_application.controllers.userController.ResponseDTO.UpdateUserResponseDTO;
import com.example.Split_Wise_application.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<CreateUserResponseDTO> createUser(CreateUserRequestDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok().body(modelMapper.map(createdUser, CreateUserResponseDTO.class));
    }

    public ResponseEntity<GetUserByIdResponseDTO> getUserById(int userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(modelMapper.map(user, GetUserByIdResponseDTO.class));
    }

    public ResponseEntity<List<GetUserByIdResponseDTO>> getAllUsers(){
        List<User> users = userService.getAllUsers();

        List<GetUserByIdResponseDTO> userList = new ArrayList<>();
        for (User user : users)
            userList.add(modelMapper.map(user, GetUserByIdResponseDTO.class));

        return ResponseEntity.ok().body(userList);
    }

    public ResponseEntity<String> deleteUser(int userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().body("User deleted successfully");
    }

    public ResponseEntity<UpdateUserResponseDTO> updateUser(int userId, UpdateUserRequestDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user = userService.updateUser(user, userId);
        return ResponseEntity.ok().body(modelMapper.map(user, UpdateUserResponseDTO.class));
    }
}
