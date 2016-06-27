package com.roytrack.dailytest.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * unresolved
 *
 * Created by roytrack on 2016/6/27.
 */
public class SubString30 {
    public  static  int count=0;
    public static int subLength=0;
    public static void main(String[] args) {
        String s="barfoothefoobarman";
        s="wordgoodgoodgoodbestword";
        s="aaaaaaaa";
        String [] words
//                ={"foo", "bar","man"};
//        words
                //={"word","good","best","good"};
        ={"aa","aa","aa"};
        SubString30 s3=new SubString30();
        HashSet<Integer> result=new HashSet<>();
        s3.allRange(words, 0, s,result);

        for(Integer i:result){
            System.out.print(i + "\t");
        }
    }

    public   void swap (String [] words,int a,int b){
        String c=words[a];
        words[a]=words[b];
        words[b]=c;
    }

    public  void indexOf(String target,String [] words,HashSet<Integer> result){
        String jonStr=String.join("",words);
        Integer index=target.indexOf(jonStr);
        if(index>=0){
            result.add(subLength+index);
//            System.out.println(index);
            if(jonStr.length()<=target.length()){
                String c=target.substring(1);
                subLength++;
                indexOf(c,words,result);
            }
        }
    }
    public    void allRange(String[] words,int start,String target,HashSet<Integer>result){

//        System.out.println("====="+String.join("",words)+"======="+(count++));
        if(start==words.length-1){
            subLength=0;
            indexOf(target,words,result);
        }else{
            for(int i=start;i<words.length;  i++){

                swap(words,start,i);
//                System.out.println(String.join("",words));
                allRange(words, start+1,target,result);
                swap(words,start,i);
            }
        }
    }
    public  List<Integer> findSubString(String s,String[] words){
        HashSet<Integer> result=new HashSet<>();
        allRange(words,0,s,result);
        ArrayList<Integer> r=new ArrayList<>(result);
        return r;

    }
}
