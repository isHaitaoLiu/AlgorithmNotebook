/*
    - 题目描述：将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
              如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
              你不能更改节点中的值，只能更改节点本身。
              要求空间复杂度 O(1)
    - 知识点：递归、链表、头插法
    - 题目解析：   （1）链表长度不超过K则直接返回头节点；（2）链表长度超过k，则利用头插法，反转k个，原先头指针指向后面的链表，递归反转
    - 代码解析： 
*/

public class Solution {
    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head, p;
        int num = 0;
        while(cur != null && num < k){
            num++;
            cur = cur.next;
        }
        if(num < k){
            return head;
        }else{
            cur = head;
            while(num > 0){
                num--;
                p = cur.next;
                cur.next = dummy.next;
                dummy.next = cur;
                cur = p;
            }
            head.next = reverseKGroup(cur, k);
            return dummy.next;
        }
    }
}