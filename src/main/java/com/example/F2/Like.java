package com.example.F2;

import jakarta.persistence.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table(name = "LIK")
@Component("Like")
@DependsOn("post")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id5", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id5", referencedColumnName = "id")
    private Post post;

    @Column(name="date_time_liked")
    private LocalDateTime dateTimeLiked;

    public Like() {}

    public Like(User user, Post post, LocalDateTime dateTimeLiked) {
        this.user = user;
        this.post = post;
        this.dateTimeLiked = dateTimeLiked;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getDateTimeLiked() {
        return dateTimeLiked;
    }

    public void setDateTimeLiked(LocalDateTime dateTimeLiked) {
        this.dateTimeLiked = dateTimeLiked;
    }

}
