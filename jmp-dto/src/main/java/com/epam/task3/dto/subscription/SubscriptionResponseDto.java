package com.epam.task3.dto.subscription;

import com.epam.task3.dto.user.UserResponseDto;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class SubscriptionResponseDto extends RepresentationModel<SubscriptionResponseDto> {
    Long id;
    Long userId;
    String startDate;
}
