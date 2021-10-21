/*
    - 题目描述：
        在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
        例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    - 知识点：链表
    - 题目解析：
        遍历链表，循环体每次向后搜索val相同的结点，统计其个数，如果个数超过1，则不做任何操作；
        如果个数==1，则将其链接到结果链表的后面
    - 代码解析：
*/


public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = pHead, pre = dummy;
        while(cur != null){
            int val = cur.val;
            int counter = 0;
            ListNode p = cur;
            while(cur != null && cur.val == val){
                cur = cur.next;
                counter++;
            }
            if(counter > 1) continue;
            else{
                pre.next = p;
                pre = pre.next;
                pre.next = null;
            }
        }
        return dummy.next;
    }
}