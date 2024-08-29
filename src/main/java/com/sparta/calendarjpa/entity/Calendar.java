package com.sparta.calendarjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Calendar extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String todo;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public Calendar(String name, String title, String todo) {
        this.name = name;
        this.title = title;
        this.todo = todo;
    }

    public void update(String title, String todo) {
        this.title = title;
        this.todo = todo;
    }
}
