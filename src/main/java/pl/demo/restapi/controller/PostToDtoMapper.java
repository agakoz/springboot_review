package pl.demo.restapi.controller;

import pl.demo.restapi.dto.PostDTO;
import pl.demo.restapi.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostToDtoMapper {

    private PostToDtoMapper() {}

    public static PostDTO mapToPostDto(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public static List<PostDTO> mapToPostDtos(List<Post> posts) {
        return posts.stream().map(post -> mapToPostDto(post)).collect(Collectors.toList());
    }

}
