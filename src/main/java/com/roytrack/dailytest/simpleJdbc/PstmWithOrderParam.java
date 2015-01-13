package com.roytrack.dailytest.simpleJdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 不返回值 对于mybatis 如果是要放个原样 用 ORDER BY ${columnName}  其他需要设置为参数的 用 #{lastName}
 * Created by roytrack on 2015/1/11.
 */
public class PstmWithOrderParam {

    @Test
    public void OrderInParam() throws SQLException {
        Connection con=Aconnection.getInstance().getConn();
        PreparedStatement pstm=con.prepareStatement("select * from help_keyword order by ?");
        pstm.setString(1,"name");
        ResultSet rs=pstm.getResultSet();
        System.out.println(rs);
        if(rs!=null){
            rs.next();
            System.out.println(rs.getString("name"));
        }

    }

    @Test
    public void LimitInParam() throws SQLException {
        Connection con=Aconnection.getInstance().getConn();
        PreparedStatement pstm=con.prepareStatement("select * from help_keyword limit ?,?");
        pstm.setInt(1, 5);
        pstm.setInt(2,5);
        ResultSet rs=pstm.getResultSet();
        System.out.println(rs);
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        if(rs!=null){
            rs.next();
            System.out.println(rs.getString("name"));
        }

    }
}
