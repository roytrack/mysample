package com.roytrack.mybatis.complexMap.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by roytrack on 2016-09-17.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Tag {
    private int tagId;
    private String tagName;
}
