package com.epam.task3.service.cloud;

import com.epam.task3.dto.subscription.SubscriptionRequestDto;
import com.epam.task3.dto.subscription.SubscriptionResponseDto;
import com.epam.task3.entity.SubscriptionEntity;
import com.epam.task3.repository.SubscriptionRepository;
import com.epam.task3.service.SubscriptionService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CloudSubscriptionService implements SubscriptionService {

    private SubscriptionRepository subscriptionRepository;
    private ModelMapper modelMapper;

    @Override
    public SubscriptionResponseDto getSubscription(Long id) {
        Optional<SubscriptionEntity> subscriptionOption = subscriptionRepository.findById(id);
        if (subscriptionOption.isEmpty()) {
            return null;
        }
        SubscriptionEntity subscription = subscriptionOption.get();
        SubscriptionResponseDto response = modelMapper.map(subscription, SubscriptionResponseDto.class);
        return response;
    }

    @Override
    public List<SubscriptionResponseDto> getAllSubscriptions() {
        List<SubscriptionEntity> subscriptionOption = subscriptionRepository.findAll();
        List<SubscriptionResponseDto> subscriptionsDto = subscriptionOption.stream()
            .map(subscription -> modelMapper.map(subscription, SubscriptionResponseDto.class))
            .collect(Collectors.toList());
        return subscriptionsDto;
    }

    @Override
    public List<SubscriptionResponseDto> getAllSubscriptionsByUserId(Long userId) {
        List<SubscriptionEntity> subscriptionOption = subscriptionRepository.findAllByUser_Id(userId);
        List<SubscriptionResponseDto> subscriptionsDto = subscriptionOption.stream()
            .map(subscription -> modelMapper.map(subscription, SubscriptionResponseDto.class))
            .collect(Collectors.toList());
        return subscriptionsDto;
    }

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        subscriptionRequestDto.setId(null);
        SubscriptionEntity subscriptionEntity = modelMapper.map(subscriptionRequestDto, SubscriptionEntity.class);
        SubscriptionEntity saved = subscriptionRepository.save(subscriptionEntity);
        return modelMapper.map(saved, SubscriptionResponseDto.class);
    }

    @Override
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        SubscriptionEntity subscriptionEntity = modelMapper.map(subscriptionRequestDto, SubscriptionEntity.class);
        SubscriptionEntity saved = subscriptionRepository.save(subscriptionEntity);
        return modelMapper.map(saved, SubscriptionResponseDto.class);
    }

    @Override
    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
