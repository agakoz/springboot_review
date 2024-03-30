package pl.demo.restapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.*;

@Getter
@Setter
@Entity
//@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String title;
    private String content;
//    private LocalTime created;

    @OneToMany(cascade = REMOVE)
    @JoinColumn(name = "postId", updatable = false, insertable = false)
    private List<Comment> comments;

}
