package com.roytrack.dailytest.leetcode;

/**
 * Created by roytrack on 2016/7/18.
 */
public class RoomProblem
{
    public static void main(String[] args) {
        int [] a={0,4,3,2,4,5,6};
        int k=0,ans=0,w=0,t=0;
        for(int i=0;i<a.length;i++){
            t=0;
            for(int j=1;j<a.length-1;j++){
                w=(i+j)%(a.length-1);
                if(w==0)w=a.length-1;
                t=a[w]*j;
            }
            if(t<ans){
                k=i;ans=t;
            }
        }
        System.out.println("k is "+k+"  ans is "+ans);
    }

}
