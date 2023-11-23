package com.example.Split_Wise_application;

import com.example.Split_Wise_application.commands.CommandRegistory;
import com.example.Split_Wise_application.commands.CommandRegistoryImpl;
import com.example.Split_Wise_application.commands.RegisterUserCommand;
import com.example.Split_Wise_application.commands.UpdateUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableJpaAuditing
public class SplitWiseApplication implements CommandLineRunner {

	@Autowired
	private CommandRegistory commandRegistory;
	@Autowired
	private RegisterUserCommand registerUserCommand;
	@Autowired
	private UpdateUserCommand updateUserCommand;

	InputStreamReader r=new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(r);


	public static void main(String[] args) {
		SpringApplication.run(SplitWiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		commandRegistory.registerCommand(registerUserCommand);
		commandRegistory.registerCommand(updateUserCommand);

		System.out.println("Ready");

		while(true)
		{
			String input = br.readLine();

//			String input = "Register Nikhil 222 password";

			commandRegistory.executeCommandLine(input);
		}
	}
}