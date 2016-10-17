package com.roytrack.netty.encode_6_1;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * Created by roytrack on 2016-10-17.
 */
public class UserInfo implements Serializable{
    private static final long serialVersionUID=1L;
    private String userName;
    private int userId;
    public UserInfo buildUserName(String userName){
        this.userName=userName;
        return this;
    }
    public UserInfo buildUserId(int userId){
        this.userId=userId;
        return this;
    }

    public final void setUserName(String userName) {
        this.userName = userName;
    }

    public final void setUserId(int userId) {
        this.userId = userId;
    }

    public final String getUserName(){

        return this.userName;
    }
    public final int getUserId(){
        return this.userId;
    }

    public byte[] codeC(){
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        byte [] value=this.getUserName().getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userId);
        buffer.flip();
        value=null;
        byte[] result=new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }

}
