/*
    - 题目描述：输入一个链表，反转链表后，输出新链表的表头。
    - 知识点：链表、头插法
    - 题目解析：
    - 代码解析：
        新建一个虚拟节点，头插法将其插入到一个虚拟后面，返回虚拟节点的next即可
*/




public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while(head != null){
            ListNode pre = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = pre;
        }
        return dummy.next;
    }
}