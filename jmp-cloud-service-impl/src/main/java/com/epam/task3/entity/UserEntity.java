package com.epam.task3.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;

    @OneToMany(mappedBy="user")
    private List<SubscriptionEntity> subscriptions;
}
