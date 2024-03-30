package pl.demo.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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

    public List<Post> getPosts(Integer page, Sort.Direction sort, String sortBy) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null? sort : Sort.Direction.ASC;
        return postRepository.findAllPost(PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortDirection, sortBy)));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }

    public List<Post> getPostsWithComments(int pageNumber, Sort.Direction sortDirection, String sortBy) {
        List<Post> posts = getPosts(pageNumber, sortDirection, sortBy);
        List<Long> ids = posts.stream().map(Post::getId).collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByIdIn(ids);
        posts.forEach(post -> post.setComments(extractComments(comments, post.getId())));
        return posts;
    }

    private List<Comment> extractComments(List<Comment> comments, long postId) {
        return comments.stream().filter(comment -> comment.getPostId() == postId).collect(Collectors.toList());
    }

    public Post addPost(Post newPost) {
        return postRepository.save(newPost);
    }

    public Post editPost(Post editedPost) {
        Post post = postRepository.findById(editedPost.getId()).orElseThrow();
        post.setTitle(editedPost.getTitle());
        post.setContent(editedPost.getContent());
        postRepository.save(post);
        return post;
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    public List<Comment> getCommentsForPost(long postId) {
        return postRepository.findById(postId).orElseThrow().getComments();
    }
}
