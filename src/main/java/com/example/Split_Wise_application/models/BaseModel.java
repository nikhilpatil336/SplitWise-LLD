package com.example.Split_Wise_application.models;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(BaseModel.class)
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private String createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private String lastModifiedDate;

    private boolean deleted = false;
}
