/*
    - 题目描述：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。一趟扫描实现。
    - 知识点：双指针、快慢指针
    - 题目解析：
        一个指针先走n步即可
    - 代码解析：
*/



class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, p, pre;
        while(cur != null && n > 0){
            cur = cur.next;
            n--;
        }
        if(n > 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        p = head;
        pre = dummy;
        while(cur != null){
            cur = cur.next;
            pre = p;
            p = p.next;
        }
        if(p == null) return dummy.next;
        else{
            pre.next = p.next;
            return dummy.next;
        }
    }
}