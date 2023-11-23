package com.example.Split_Wise_application.controllers.userController.RequestDTO;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UpdateUserRequestDTO {

    private String name;
    private String password;
    private String phoneNo;
}
