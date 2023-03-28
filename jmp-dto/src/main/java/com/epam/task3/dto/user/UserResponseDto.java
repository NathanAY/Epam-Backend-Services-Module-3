package com.epam.task3.dto.user;

import com.epam.task3.dto.subscription.SubscriptionResponseDto;
import java.util.List;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class UserResponseDto extends RepresentationModel<UserResponseDto> {

    private Long id;
    private String name;
    private String surname;
    private String birthday;

    private List<SubscriptionResponseDto> subscriptions;

}
