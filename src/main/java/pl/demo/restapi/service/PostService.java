package pl.demo.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.demo.restapi.dto.PostDTO;
import pl.demo.restapi.model.Comment;
import pl.demo.restapi.model.Post;
import pl.demo.restapi.repository.CommentRepository;
import pl.demo.restapi.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private static final int PAGE_SIZE = 5;
    final PostRepository postRepository;
    final CommentRepository commentRepository;

    public List<Post> getPosts(int page) {
        return postRepository.findAllPost(PageRequest.of(page, PAGE_SIZE));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }

    public List<Post> getPostsWithComments(int pageNumber) {
        List<Post> posts = getPosts(pageNumber);
        List<Long> ids = posts.stream().map(Post::getId).collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByIdIn(ids);
        posts.forEach(post -> post.setComments(extractComments(comments, post.getId())));
        return posts;
    }

    private List<Comment> extractComments(List<Comment> comments, long postId) {
        return comments.stream().filter(comment -> comment.getPostId() == postId).collect(Collectors.toList());
    }
}
