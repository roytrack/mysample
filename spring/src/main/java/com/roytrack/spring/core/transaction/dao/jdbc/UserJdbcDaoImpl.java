package com.roytrack.spring.core.transaction.dao.jdbc;


import com.roytrack.spring.core.transaction.dao.IUserDao;
import com.roytrack.spring.core.transaction.model.UserModel;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserJdbcDaoImpl extends NamedParameterJdbcDaoSupport implements IUserDao {

    private final String INSERT_SQL = "insert into user(name) values(:name)";
    private final String COUNT_ALL_SQL = "select count(*) from user";

    
    @Override
    public void save(UserModel user) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        getNamedParameterJdbcTemplate().update(INSERT_SQL, paramSource, generatedKeyHolder);
        user.setId(generatedKeyHolder.getKey().intValue());
    }

    @Override
    public int countAll() {
       return getJdbcTemplate().queryForInt(COUNT_ALL_SQL);
    }
    
}
