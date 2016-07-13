package com.roytrack.dailytest.leetcode;

import java.util.Arrays;

/**
 * Created by roytrack on 2016-07-13.
 */
public class Sum3Closest16Good {

    public static void main(String[] args) {
        int [] target={10,3,4,2,-1,2};
        Arrays.sort(target);
        for(int i=0;i<target.length;i++){
            System.out.println(target[i]);
        }
        Sum3Closest16Good g=new Sum3Closest16Good();
        System.out.println("result  " + g.threeSumClosest(new int []{0,2,1,-3},1));
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length=nums.length;
        int absVal=-1;
        int closestSum=-1;
        //否则依次循环将三个数相加与目标值比较，并记录最小的绝对值
        // 由于最起码要三个数 并且上面把最大 最小 三个数的情况已经排除 所以只需要进行
        //这里需要一个二分查找的办法来对三个数进行相加
        for(int i=0;i<length-2;i++){
            int start=i+1;
            int end=length-1;
            while (start<end){
                int sum=nums[i]+nums[start]+nums[end];
                int abs=Math.abs(sum-target);
                if(absVal==-1||abs <absVal){
                    absVal=abs;
                    closestSum=sum;

                }
                if(sum<target){
                    start++;
                }
                else if(sum>target){
                    end--;
                }else {
                    return closestSum;
                }
            }

        }
        return closestSum;
    }
}
