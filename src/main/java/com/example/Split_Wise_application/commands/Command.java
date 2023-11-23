package com.example.Split_Wise_application.commands;

public interface Command {

    boolean parse(String commandLine);

    void execute(String commandLine);
}
