package com.epam.task3.rest.maturity2;

import com.epam.task3.dto.subscription.SubscriptionRequestDto;
import com.epam.task3.dto.subscription.SubscriptionResponseDto;
import com.epam.task3.service.SubscriptionService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("SubscriptionControllerMaturityLevel2")
@AllArgsConstructor
@RequestMapping("/v2/users/{userId}/subscriptions")
public class SubscriptionController {

    private SubscriptionService service;

    @GetMapping("/{id}")
    public SubscriptionResponseDto getSubscription(@PathVariable Long id) {
        SubscriptionResponseDto subscription = service.getSubscription(id);
        return subscription;
    }

    @GetMapping
    public List<SubscriptionResponseDto> getAllUserSubscriptions(@PathVariable Long userId) {
        List<SubscriptionResponseDto> subscriptions = service.getAllSubscriptionsByUserId(userId);
        return subscriptions;
    }

    @PostMapping
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        SubscriptionResponseDto responseDto = service.createSubscription(subscriptionRequestDto);
        return responseDto;
    }

    @PutMapping("/{id}")
    public SubscriptionResponseDto updateSubscription(@PathVariable Long id, @RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        subscriptionRequestDto.setId(id);
        return service.updateSubscription(subscriptionRequestDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSubscription(@PathVariable Long id) {
        service.deleteSubscription(id);
        return true;
    }
}
