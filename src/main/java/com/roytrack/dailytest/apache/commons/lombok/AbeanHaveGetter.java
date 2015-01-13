package com.roytrack.dailytest.apache.commons.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by roytrack on 2015/1/11.
 */
@ToString(callSuper = true, includeFieldNames = true)
@Getter
@Setter
public class AbeanHaveGetter {
    private String name;
    private String foo;
    public String  getFoo(){
        return foo+"aa";
    }
}
