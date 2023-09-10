package com.example.Subject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private int courseId;
}
