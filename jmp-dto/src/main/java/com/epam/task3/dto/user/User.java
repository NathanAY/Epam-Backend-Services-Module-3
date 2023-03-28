package com.epam.task3.dto.user;

import java.time.LocalDate;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;
}
