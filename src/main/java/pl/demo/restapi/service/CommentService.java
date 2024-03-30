package pl.demo.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.demo.restapi.model.Comment;
import pl.demo.restapi.model.Post;
import pl.demo.restapi.repository.CommentRepository;
import pl.demo.restapi.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;
    private final PostRepository postRepository;

    public Comment addCommentForPost(Comment comment) {
        if(!postRepository.existsById(comment.getPostId())) throw new IllegalArgumentException("Post doesnt exist");
        commentRepository.save(comment);
        return comment;
    }
}
