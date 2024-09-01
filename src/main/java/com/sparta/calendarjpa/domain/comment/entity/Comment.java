package com.sparta.calendarjpa.domain.comment.entity;

import com.sparta.calendarjpa.domain.calendar.entity.Calendar;
import com.sparta.calendarjpa.domain.common.entity.Timestamped;
import com.sparta.calendarjpa.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id", nullable = false)
    private Calendar calendar;

    public Comment(String contents, User user, Calendar calendar) {
        this.contents = contents;
        this.user = user;
        this.calendar = calendar;
    }

    public void update(String contents) {
        this.contents = contents;
    }
}
