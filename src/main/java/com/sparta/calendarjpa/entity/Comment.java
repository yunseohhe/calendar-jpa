package com.sparta.calendarjpa.entity;

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
    private String username;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    public Comment(String contents, String username, Calendar calendar) {
        this.contents = contents;
        this.username = username;
        this.calendar = calendar;
    }

    public void update(String contents) {
        this.contents = contents;
    }
}
