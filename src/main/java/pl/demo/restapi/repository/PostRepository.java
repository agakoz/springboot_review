package pl.demo.restapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.demo.restapi.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    @Query("Select p from Post p " +
//            "left join fetch p.comments")
    @Query("Select p from Post p")
    List<Post> findAllPost(Pageable page);
}
