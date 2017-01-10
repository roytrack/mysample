package com.roytrack.dailytest.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *Output: 7 -> 0 -> 8
 *
 * Created by roytrack on 2017-01-04.
 */
public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode l11=new ListNode(2);
        ListNode l12=new ListNode(4);
        l11.next=l12;
        ListNode l13=new ListNode(3);
        l12.next=l13;
        ListNode l21=new ListNode(5);
        ListNode l22=new ListNode(6);
        l21.next=l22;
        ListNode l23=new ListNode(4);
        l22.next=l23;
        AddTwoNumbers_2 s=new AddTwoNumbers_2();
        ListNode result=s.addTwoNumbers(l11,l21);
        while (null!=result){
            System.out.println(result.val+"--->");
            result=result.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode=null,tmpNode=null;
        int sum,addFlag=0;
        while(null!=l1||null!=l2||addFlag!=0){
            if(l1==null&&l2==null){
                sum=addFlag;
            }else{
                if(l1==null){
                    sum=l2.val+addFlag;
                }else if(l2==null){
                    sum=l1.val+addFlag;
                }else {
                    sum=l1.val+l2.val+addFlag;
                }

            }

            if(sum/10==1){
                addFlag=1;
            }else{
                addFlag=0;
            }
            if(resultNode==null){
                resultNode=new ListNode(sum%10);
                tmpNode=resultNode;
            }else{
                ListNode newNode=new ListNode(sum%10);
                tmpNode.next=newNode;
                tmpNode=newNode;
            }
            l1=l1.next;
            l2=l2.next;
        }

        return resultNode;
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}
