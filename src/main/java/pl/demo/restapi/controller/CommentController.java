package pl.demo.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.demo.restapi.model.Comment;
import pl.demo.restapi.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
   private final CommentService commentService;
    @PostMapping("/posts/{postId}/addComment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addCommentForPost(comment);
    }

}
