package pl.demo.restapi.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostDTO {
    private long id;
    private String title;
    private String content;
}
