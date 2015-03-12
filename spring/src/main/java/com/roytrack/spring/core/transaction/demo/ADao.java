package com.roytrack.spring.core.transaction.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by roytrack on 2015/1/30.
 */
@Getter
@Setter
public class ADao {
    private DataSource dataSource;
    public void update(){
        JdbcTemplate template=new JdbcTemplate(dataSource);
        template.update("update a set  a=1,b=2 where c=3");
    }
}
