package com.sparta.calendarjpa.domain.calendar.entity;

import com.sparta.calendarjpa.domain.comment.entity.Comment;
import com.sparta.calendarjpa.domain.common.entity.Timestamped;
import com.sparta.calendarjpa.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Calendar extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String todo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();


    public Calendar(User user, String title, String todo) {
        this.user = user;
        this.title = title;
        this.todo = todo;
    }

    public void update(String title, String todo) {
        this.title = title;
        this.todo = todo;
    }
}
