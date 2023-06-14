package com.example.F2;

import jakarta.persistence.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Component("Comment")
@DependsOn("post")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id3", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id3", referencedColumnName = "id")
    private Post post;

    @Column(name = "date_time_posted")
    private LocalDateTime dateTimePosted;

    private String content;

    public Comment() {
    }

    public Comment(Long id, User user, Post post, LocalDateTime dateTimePosted, String content) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.dateTimePosted = dateTimePosted;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getDateTimePosted() {
        return dateTimePosted;
    }

    public void setDateTimePosted(LocalDateTime dateTimePosted) {
        this.dateTimePosted = dateTimePosted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
