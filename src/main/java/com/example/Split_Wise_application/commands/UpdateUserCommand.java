package com.example.Split_Wise_application.commands;

import com.example.Split_Wise_application.controllers.userController.RequestDTO.UpdateUserRequestDTO;
import com.example.Split_Wise_application.controllers.userController.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateUserCommand implements Command {

    @Autowired
    private UserController userController;

    @Override
    public boolean parse(String commandLine) {

        List<String> commandTokens = List.of(commandLine.split(" "));

        if (commandTokens.size() != 3)
            return false;

        if(!commandTokens.get(0).equals(CommandKeywords.UPDATE_USER_COMMAND))
            return false;

        return true;
    }

    @Override
    public void execute(String commandLine) {
        String[] tokens = commandLine.split(" ");

        int id = Integer.parseInt(tokens[1]);
        String userName = tokens[2];
        int phoneNumber = Integer.parseInt(tokens[3]);
        String password = tokens[4];

        UpdateUserRequestDTO userDTO = new UpdateUserRequestDTO();
        userDTO.setName(userName);
        userDTO.setPhoneNo(String.valueOf(phoneNumber));
        userDTO.setPassword(password);

        userController.updateUser(id, userDTO);
    }
}
