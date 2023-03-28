package com.epam.task3.dto.user;

import lombok.Data;

@Data
public class UserRequestDto {
    private Long id;
    private String name;
    private String surname;
    private String birthday;
}
