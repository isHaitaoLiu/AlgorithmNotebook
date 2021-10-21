/*
    - 题目描述：
        给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
    - 知识点：链表
    - 题目解析：
        （1）快慢指针判断有无环，有环情况下，快慢指针会碰撞
        （2）快指针留在碰撞的位置，慢指针指向链表首部，两指针以同样的速度（每次1）前进，碰撞时即环的入口节点
    - 代码解析：
*/


public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead, fast = pHead;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;
        slow = pHead;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}