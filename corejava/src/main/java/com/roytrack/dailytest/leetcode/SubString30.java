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
    HashSet<String> hitResult=new HashSet<>();
    public static void main(String[] args) {
        String s="barfoothefoobarman";
        s="wordgoodgoodgoodbestword";
        String [] words
//                ={"foo", "bar","man"};
//        words
                ={"word","good","best","good"};
        SubString30 s3=new SubString30();
        List<Integer> result=new ArrayList<>();
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
    public    void allRange(String[] words,int start,String target,List<Integer>result){

        System.out.println("====="+String.join("",words)+"======="+(count++));
        if(start==words.length-1){

            if(target.indexOf(String.join("",words))>=0&&!hitResult.contains(String.join("",words))){
                result.add(target.indexOf(String.join("",words)));
                hitResult.add(String.join("",words));
                System.out.println(target.indexOf(String.join("",words)));
            }
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
        List<Integer> result=new ArrayList<>();
        allRange(words,0,s,result);
        return result;

    }
}
