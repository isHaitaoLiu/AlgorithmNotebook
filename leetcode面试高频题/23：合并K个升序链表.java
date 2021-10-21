/*
    - 题目描述：给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
    - 知识点：链表、分治
    - 题目解析：
        （1）先设计一个两个升序链表合并的函数
        （2）分而治之，先将链表数组拆分，直到拆分为1条一组，之后两两合并
    - 代码解析：
*/


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        if(l > r) return null;
        if(l == r) return lists[l];
        int mid = l + r >> 1;
        return mergeTowLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTowLists(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0), cur = res;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }
}