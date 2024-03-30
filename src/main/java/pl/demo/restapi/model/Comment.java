package pl.demo.restapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private long postId;
    private String content;
    private LocalDateTime created;
}
