package pl.demo.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.demo.restapi.dto.PostDTO;
import pl.demo.restapi.model.Comment;
import pl.demo.restapi.model.Post;
import pl.demo.restapi.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/posts")
    public List<PostDTO> getPostsSortId(@RequestParam(required = false) Integer page, Sort.Direction sort) throws IllegalAccessException {
        return PostToDtoMapper.mapToPostDtos(postService.getPosts(page, sort, "id"));
    }

//    @GetMapping("/posts/titleSort")
//    public List<PostDTO> getPostsSortTitle(@RequestParam(required = false) Integer page, Sort.Direction sort) throws IllegalAccessException {
//        return PostToDtoMapper.mapToPostDtos(postService.getPosts(page, sort, "title"));
//    }

//    @GetMapping("/posts/comments/idSort")
//    public List<Post> getPostsWithCommentsSortId(@RequestParam(required = false) Integer page,  Sort.Direction sort) throws IllegalAccessException {
//        int pageNumber = page != null && page >= 0 ? page : 0;
//        Sort.Direction sortDirection = sort != null? sort : Sort.Direction.ASC;
//        return postService.getPostsWithComments(pageNumber, sortDirection, "id");
//    }

//    @GetMapping("/posts/comments/titleSort")
//    public List<Post> getPostsWithCommentsSortTitle(@RequestParam(required = false) Integer page,  Sort.Direction sort) throws IllegalAccessException {
//        int pageNumber = page != null && page >= 0? page : 0;
//        Sort.Direction sortDirection = sort != null? sort : Sort.Direction.ASC;
//        return postService.getPostsWithComments(pageNumber, sortDirection, "title");
//    }

    @GetMapping("/posts/{id}")
    public Post getSiglePost(@PathVariable long id) throws IllegalAccessException {
        return postService.getSinglePost(id);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post newPost) {
        return postService.addPost(newPost);
    }

    @PutMapping("/posts")
    public Post editPost(@RequestBody Post editedPost) {
        return postService.editPost(editedPost);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getCommentsForPost(@PathVariable long postId) {
        return postService.getCommentsForPost(postId);
    }

    public void deletePost(@RequestParam long id) {
        postService.deletePost(id);
    }
}
