package com.roytrack.kryo;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 开始组装一个1000内容的list  2015-11-08 10:50:19 019
 装配完毕  2015-11-08 10:50:19 019  耗时毫秒   3
 序列化结束  2015-11-08 10:50:19 019  耗时毫秒   49
 序列化结束 的大小  103997
 反序列化结束  2015-11-08 10:50:19 019  耗时毫秒   34
 对比结束   2015-11-08 10:50:19 019  耗时毫秒   2
 相等个数 1000   不相等个数  0
 * Created by roytrack on 2015/11/8.
 */
public class PerformanceJavaDemo {
    public static void main(String[] args) {
        JdkSerializationRedisSerializer k=new JdkSerializationRedisSerializer();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss sss");
        System.out.println("开始组装一个1000内容的list  "+sdf.format(new Date()));
        long now=System.currentTimeMillis();
        List<Book> list=new ArrayList<Book>();
        for(int i=0;i<1000;i++){
            Book b=new Book();
            b.setBookName("我的奋斗"+i);
            b.setISBN("8493242" + i);
            b.setPrice(new BigDecimal(5 + i));
            b.setPublicationDate(new Date());
            list.add(b);
        }
        System.out.println("装配完毕  "+sdf.format(new Date())+"  耗时毫秒   "+(System.currentTimeMillis()-now));
        now=System.currentTimeMillis();
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream(256);
      byte[] b=   k.serialize(list);
        System.out.println("序列化结束  " + sdf.format(new Date()) + "  耗时毫秒   " + (System.currentTimeMillis() - now));
        System.out.println("序列化结束 的大小  "+b.length);
        now=System.currentTimeMillis();
        List<Book> bookList=(List<Book>)k.deserialize(b);
        System.out.println("反序列化结束  " + sdf.format(new Date()) + "  耗时毫秒   " + (System.currentTimeMillis() - now));
        now=System.currentTimeMillis();
        int equal=0,unequal=0;
        for(int i=0;i<1000;i++){
            if(list.get(i).equals((Book)bookList.get(i))){
                equal++;
            }else {
                unequal++;
            }
        }
        System.out.println("对比结束   " + sdf.format(new Date()) + "  耗时毫秒   " + (System.currentTimeMillis() - now));
        System.out.println("相等个数 "+equal+"   不相等个数  "+unequal);

    }
}
