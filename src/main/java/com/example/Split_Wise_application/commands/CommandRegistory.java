package com.example.Split_Wise_application.commands;

import java.util.List;

public interface CommandRegistory {

    void registerCommand(Command command);

    Command getCommand(String commandLine);

    void removeCommand(Command command);

    boolean executeCommandLine(String commandLine);
}
