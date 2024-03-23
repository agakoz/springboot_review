package pl.demo.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.demo.restapi.dto.PostDTO;
import pl.demo.restapi.model.Post;
import pl.demo.restapi.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/posts")
    public List<PostDTO> getPosts(@RequestParam(required = false) int page) throws IllegalAccessException {
        int pageNumber = page >= 0 ? page : 0;
        return PostToDtoMapper.mapToPostDtos(postService.getPosts(pageNumber));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(@RequestParam(required = false) int page) throws IllegalAccessException {
        int pageNumber = page >= 0 ? page : 0;
        return postService.getPostsWithComments(pageNumber);
    }

    @GetMapping("/posts/{id}")
    public Post getSiglePost(@PathVariable long id) throws IllegalAccessException {
        return postService.getSinglePost(id);
    }
}
