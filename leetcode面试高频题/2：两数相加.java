/*
    - 题目描述：给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
              请你将两个数相加，并以相同形式返回一个表示和的链表。
              你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    - 知识点：链表
    - 题目解析： 按照整数加法累加即可
    - 代码解析： 注意！进位不可丢
*/


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0, b = 0, carry = 0;
        ListNode dummy = new ListNode(0), cur = dummy;
        while(l1 != null || l2 != null || carry != 0){
            a = l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;
            int sum = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        return dummy.next;
    }
}