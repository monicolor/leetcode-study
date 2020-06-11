package com.colorx.easy;

/**
 * @author colorx
 * @version 1.0
 * @date 2020/6/11 11:17
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode a1 = new ListNode("a1");
        ListNode a2 = new ListNode("a1");

        ListNode b1 = new ListNode("b1");
        ListNode b2 = new ListNode("b2");
        ListNode b3 = new ListNode("b3");


        ListNode c1 = new ListNode("c1");
        ListNode c2 = new ListNode("c2");
        ListNode c3 = new ListNode("c3");
        a1.setNext(a2).setNext(c1);
        b1.setNext(b2).setNext(b3).setNext(c1);
        c1.setNext(c2).setNext(c3);
        System.out.println(getIntersectionNode(a1, b1).getVal());
    }
     static class ListNode{
        String val;
        ListNode next;

         public ListNode(String val) {
             this.val = val;
         }

         public String getVal() {
             return val;
         }

         public void setVal(String val) {
             this.val = val;
         }

         public ListNode getNext() {
            return next;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return next;
        }
    }

    public static ListNode  getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode l1 = headA,l2 = headB;
       while (l1 != l2){
            l1 = l1 == null? headB : l1.next;
            l2 = l2 == null? headA : l2.next;
       }
       return l1;
    }
}
