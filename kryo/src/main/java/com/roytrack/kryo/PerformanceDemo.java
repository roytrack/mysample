package com.roytrack.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.roytrack.kryo.factory.KryoFactory;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 结果
 * 开始组装一个1000内容的list  2015-10-26 16:26:54 054
 装配完毕  2015-10-26 16:26:54 054  耗时毫秒   9
 序列化结束  2015-10-26 16:26:54 054  耗时毫秒   40
 序列化结束 的大小  43661
 反序列化结束  2015-10-26 16:26:54 054  耗时毫秒   58
 对比结束   2015-10-26 16:26:54 054  耗时毫秒   4
 相等个数 1000   不相等个数  0
 *
 * Created by ruanchangming on 2015/10/26.
 */
public class PerformanceDemo {
    public static void main(String[] args) {
        KryoFactory factory=  KryoFactory.getDefaultFactory();
        Kryo k=factory.getKryo();
        k.register(Book.class);
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
        Output output=new Output(10000,200000);
        k.writeClassAndObject(output, list);
        System.out.println("序列化结束  " + sdf.format(new Date()) + "  耗时毫秒   " + (System.currentTimeMillis() - now));
        System.out.println("序列化结束 的大小  "+output.total());
        now=System.currentTimeMillis();
        Input input=new Input(output.getBuffer());
        List<Book> bookList=(List<Book>) k.readClassAndObject(input);
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
