package com.sparta.calendarjpa.domain.manager.entity;

import com.sparta.calendarjpa.domain.calendar.entity.Calendar;
import com.sparta.calendarjpa.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Manager {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // 일정 만든 사람 id
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id", nullable = false)
    private Calendar calendar;

    public Manager(User user, Calendar calendar) {
        this.user = user;
        this.calendar = calendar;
    }
}
