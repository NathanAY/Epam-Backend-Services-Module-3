package com.epam.task3.repository;

import com.epam.task3.entity.SubscriptionEntity;
import com.epam.task3.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

    List<SubscriptionEntity> findAllByUser_Id(Long userId);
}
