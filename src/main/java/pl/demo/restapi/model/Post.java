package pl.demo.restapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
//@Table(name = "post")
public class Post {
    @Id
    private long id;
    private String title;
    private String content;
//    private LocalTime created;

    @OneToMany
    @JoinColumn(name = "postId")
    private List<Comment> comments;

}
