package com.example.Subject.entity;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private int courseId;
}
