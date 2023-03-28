package com.epam.task3.service;


import com.epam.task3.dto.subscription.SubscriptionRequestDto;
import com.epam.task3.dto.subscription.SubscriptionResponseDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
    SubscriptionResponseDto getSubscription(Long id);


    List<SubscriptionResponseDto> getAllSubscriptions();

    List<SubscriptionResponseDto> getAllSubscriptionsByUserId(Long userId);

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto);

    void deleteSubscription(Long id);

}
