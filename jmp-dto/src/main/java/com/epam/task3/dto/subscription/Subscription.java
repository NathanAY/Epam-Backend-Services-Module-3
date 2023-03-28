package com.epam.task3.dto.subscription;

import com.epam.task3.dto.user.User;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Subscription {
    Long id;
    User user;
    LocalDate startDate;
}
