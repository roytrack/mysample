package com.roytrack.dailytest.leetcode;

/**
 * 输出全排列 去重全排列 全组合
 * Created by roytrack on 2016-07-12.
 */
public class Permutation {

    private static char[] val={'0','1','2','3','4','5','6','7','8','9'};

    public static void main(String[] args) {
        Permutation p=new Permutation();
//        char [] allPerMutation={'0','1','2','3'};
//        p.allRange(allPerMutation,0,allPerMutation.length);
//        char [] allPerMutationWithoutRepeat={'a','c','a'};
//        p.allRangeWithNoRepeat(allPerMutationWithoutRepeat,0,allPerMutationWithoutRepeat.length);
        char [] allcombination={'a','b','c'};
        p.combination(allcombination);
    }

    //all permutation

    void swap(char[] target,int from,int to){
        char tmp=target[from];
        target[from]=target[to];
        target[to]=tmp;
    }

    void allRange(char [] target,int start,int length){
        if(start==length-1){
            System.out.println(String.valueOf(target));
        }else{
            for(int i=start;i<length;i++){
                swap(target,start,i);
                allRange(target, start + 1, length);
                swap(target,start,i);
            }
        }
    }

    //no repeat permutation

    boolean isSwap(char[] target,int from,int to){
        for(;from <to;from++){
            if(target[from]==target[to]){
                return false;
            }
        }
        return true;
    }

    void allRangeWithNoRepeat(char[] target,int start,int length){
        if(start==length-1){
            System.out.println(target);
        }else{
            for(int i=start;i<length;i++){
                if(isSwap(target,start,i)){
                    swap(target, start, i);
                    allRangeWithNoRepeat(target,start+1,length);
                    swap(target,start,i);
                }
            }
        }
    }

    //all combination

    void combination(char [] target){
        int n=1<<target.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<target.length;j++){
                int tmp=i;
                int t=1<<j;
                if((tmp&t)>0){
                    System.out.print(target[j]);
                }
            }
            System.out.println();
        }
    }



}
