package com.example.Split_Wise_application.commands;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandRegistoryImpl implements CommandRegistory {

    List<Command> commands = new ArrayList<>();

    @Override
    public void registerCommand(Command command) {
        commands.add(command);
    }

    @Override
    public Command getCommand(String commandLine) {
        for(Command command: commands)
            if(command.parse(commandLine))
                return command;
        return null;
    }

    @Override
    public void removeCommand(Command command) {
        commands.remove(command);
    }

    @Override
    public boolean executeCommandLine(String commandLine) {
        for(Command command: commands)
            if(command.parse(commandLine))
                command.execute(commandLine);

        return false;
    }
}
