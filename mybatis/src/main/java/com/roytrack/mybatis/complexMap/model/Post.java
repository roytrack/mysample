package com.roytrack.mybatis.complexMap.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * Created by roytrack on 2016-09-17.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Post {
  private int postId;
  private String postSubject;
  private int postBlogId;
  private int postAuthorId;
  private Date postCreatedOn;
  private String postSection;
  private String draft;
  private String postBody;
  private Author author;
  private List<Comment> comments;
  private List<Tag> tags;
}
