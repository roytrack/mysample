package com.roytrack.mybatis.complexMap.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by roytrack on 2016-09-17.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Post {
    private int id;
    private String subject;
    private Author author;
    private List<Comment> comments;
    private List<Tag> tags;
}
