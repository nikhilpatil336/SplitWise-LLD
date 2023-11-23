package com.example.Split_Wise_application.commands;

import com.example.Split_Wise_application.controllers.userController.RequestDTO.CreateUserRequestDTO;
import com.example.Split_Wise_application.controllers.userController.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterUserCommand implements Command {

    @Autowired
    private UserController userController;

    @Override
    public boolean parse(String commandLine) {
        List<String> commandTokens = List.of(commandLine.split(" "));
        if (commandTokens.size() != 4)
            return false;

        if(!commandTokens.get(0).equals(CommandKeywords.REGISTER_USER_COMMAND))
            return false;

        return true;
    }

    @Override
    public void execute(String commandLine) {
        List<String> commandTokens = List.of(commandLine.split(" "));

        String userName = commandTokens.get(1);
        int phoneNumber = Integer.parseInt(commandTokens.get(2));
        String password = commandTokens.get(3);

        CreateUserRequestDTO userDTO = new CreateUserRequestDTO();
        userDTO.setName(userName);
        userDTO.setPhoneNo(String.valueOf(phoneNumber));
        userDTO.setPassword(password);

        userController.createUser(userDTO);
    }
}
