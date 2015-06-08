package com.roytrack.dailytest.number;

/**
 * to see overflow
 * Created by ruanchangming on 2015/6/4.
 */
public class CalcContinueAdd {
    public static void main(String[] args) {
        int init=1;
        for(int i=10;i<99;i++){
            init*=i;
            System.out.println( init+"*"+i+"  result "+init+"  hex  "+Integer.toHexString(init)+"  binary  "
                    +Integer.toBinaryString(init) +"  unsignedInt  " +Integer.parseUnsignedInt(Integer.toBinaryString(init), 2));
        }
        char a=1;
        String b="1";
        char c=b.charAt(0);
        System.out.println((short)a +"   "+(short)c+"   "+("1".equals(c))+"  "+b.getBytes().length);
    }

    public static String  getOriginalCode(String binaryCode){
        char [] bitArray=binaryCode.toCharArray();
        char sign=bitArray[0];
        if(sign==49){

        }
return null;
    }
}
