package pl.demo.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.demo.restapi.model.Post;
import pl.demo.restapi.repository.PostRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private static final int PAGE_SIZE = 20;
    final PostRepository postRepository;

    public List<Post> getPosts(int page) {
        return postRepository.findAllPost(PageRequest.of(page, PAGE_SIZE));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
