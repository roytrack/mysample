package com.roytrack.dailytest.leetcode;




/**
 * 找到数组中最接近目标值的和数 自己用的排列组合的方式 但是更好的办法是先把数字排序 然后再求和
 * Created by roytrack on 2016-07-12.
 */
public class Sum3Closest16 {



    private static class ResultA{
        private int absResult;
        private int targetSum;
        private int closeResult;

        public int getAbsResult() {
            return absResult;
        }

        public void setAbsResult(int absResult) {
            this.absResult = absResult;
        }

        public int getTargetSum() {
            return targetSum;
        }

        public void setTargetSum(int targetSum) {
            this.targetSum = targetSum;
        }

        public int getCloseResult() {
            return closeResult;
        }

        public void setCloseResult(int closeResult) {
            this.closeResult = closeResult;
        }
    }

    void swap(int[] nums,int from,int to){
        int tmp=nums[from];
        nums[from]=nums[to];
        nums[to]=tmp;
    }

    boolean isSwap(int [] nums,int start,int end){
        for(;start<end;start++){
            if(nums[start]==nums[end]){
                return false;
            }
        }
        return true;
    }

    void range3(int [] nums,int start,int length,int requireLength ,ResultA a){
        if(start==requireLength){
            int sum=0;
//            System.out.print("the sum of ");
            for(int i=0;i<requireLength;i++){
//                System.out.print("  "+nums[i]+"  " );
                sum+=nums[i];
            }
//            System.out.print(" is " + sum);
            if(a.getAbsResult()==-1){
                a.setAbsResult(Math.abs(sum - a.getTargetSum()));
//                System.out.print("  absResult is " + a.getAbsResult());
                a.setCloseResult(sum);
            }else if(Math.abs(sum-a.getTargetSum())<a.getAbsResult()){
                a.setAbsResult(Math.abs(sum - a.getTargetSum()));
//                System.out.print("  absResult change to "+a.getAbsResult());
                a.setCloseResult(sum);
            }
//            System.out.println();

        }else{
            for(int i=start;i<length;i++){
                if(isSwap(nums,start,i)){
                    swap(nums,start,i);
                    range3(nums, start + 1, length, requireLength,a);
                    swap(nums,start,i);
                }

            }
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        ResultA a=new ResultA();
        a.setAbsResult(-1);
        a.setTargetSum(target);
        a.setCloseResult(-1);
        range3(nums, 0, nums.length, 3,a);
    return a.getCloseResult();
    }

    public static void main(String[] args) {
        Sum3Closest16 s=new Sum3Closest16();
//        int [] nums={-1,2,1,-4};
//        int target=1;

        int [] nums={-1,1,1};
        int target=0;
        ResultA a=new ResultA();
        a.setAbsResult(-1);
        a.setCloseResult(-1);
        s.range3(nums,0,nums.length,3,a);
        System.out.println(a.getCloseResult());
    }

}
