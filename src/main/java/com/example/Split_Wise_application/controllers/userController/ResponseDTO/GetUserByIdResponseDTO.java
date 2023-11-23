package com.example.Split_Wise_application.controllers.userController.ResponseDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetUserByIdResponseDTO {

    private String name;
    private String phoneNo;
}
