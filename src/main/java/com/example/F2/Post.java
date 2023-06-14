package com.example.F2;

import jakarta.persistence.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Component("post")
@DependsOn("user")
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @Column(name="date_time_posted")
    private LocalDateTime dateTimeLiked;

    private String content;

    public Post() {
    }

    public Post(Long id, User user, LocalDateTime dateTimeLiked, String content) {
        this.id = id;
        this.user = user;
        this.dateTimeLiked = dateTimeLiked;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return this.dateTimeLiked;
    }

    public void setLocalDateTime(LocalDateTime dateTimeLiked) {
        this.dateTimeLiked = dateTimeLiked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
