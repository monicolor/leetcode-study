package com.colorx.easy;

/**
 * @author colorx
 * @version 1.0
 * @date 2020/6/11 11:17
 * A:          a1 → a2       d1 → d2
 *                     ↘  ↗
 *                       c
 *                     ↗  ↘
 * B:    b1 → b2 → b3        e1 → e2
 * 要求时间复杂度为 O(N)，空间复杂度为 O(1)。如果不存在交点则返回 null。
 *
 * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 *
 * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 *
 * 如果不存在交点，那么 a + b = b + a，以下实现代码中 l1 和 l2 会同时为 null，从而退出循环。
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
