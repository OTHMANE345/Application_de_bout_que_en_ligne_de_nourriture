package com.example.F2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public void insertData(){
        //create User
        User user= new User();
        user.setUsername("Ali");
        user.setEmail("Ali@gmail.com");
        userRepository.save(user);

        //create a POST
        Post post = new Post();
        post.setContent("My first post");
        post.setUser(user);
        postRepository.save(post);

        //create a Comment
        Comment comment = new Comment();
        comment.setContent("Great post!");
        comment.setUser(user);
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
