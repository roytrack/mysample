package com.roytrack.dailytest.faceTest;

/**
 * Created by ruanchangming on 2015/3/25.
 */
public class FindLongestString {
    public static void main(String[] args) {
        String theStr=args[0];
        char[] chars=theStr.toCharArray();
        int total=0 ,nowlength=1;
        char last=0;
        for(int i=0;i<chars.length;i++){
            if(i!=0) {
                if (chars[i] == last) {
                    total = (total > nowlength ? total : nowlength);
                    nowlength=1;
                } else {
                    nowlength++;
                }
            }
            last=chars[i];
            if(i==(chars.length-1)&&total<nowlength){
                total=nowlength;
            }
            System.out.println(last+"    "+total+"   "+nowlength);
        }
        System.out.println(total);

    }
}
