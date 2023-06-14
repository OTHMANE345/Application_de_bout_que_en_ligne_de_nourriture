package com.example.F2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Entity
@Component("Friendship")
@DependsOn("user")
public class Friendship {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="friend_1_id",referencedColumnName = "id" )
    private User friend1;

    @ManyToOne
    @JoinColumn(name="friend_2_id",referencedColumnName = "id" )
    private User friend2;


    public Friendship() {
    }

    public Friendship(Long id, User friend1, User friend2) {
        this.id = id;
        this.friend1 = friend1;
        this.friend2 = friend2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFriend1() {
        return friend1;
    }

    public void setFriend1(User friend1) {
        this.friend1 = friend1;
    }

    public User getFriend2() {
        return friend2;
    }

    public void setFriend2(User friend2) {
        this.friend2 = friend2;
    }
}
