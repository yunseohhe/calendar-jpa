package com.sparta.calendarjpa.domain.user.entity;

import com.sparta.calendarjpa.domain.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(unique = true)
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
