/*
    - 题目描述：输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
        如果该链表长度小于k，请返回一个长度为 0 的链表。
    - 知识点：链表、双指针
    - 题目解析：
    - 代码解析：
        设置一个指针head从头开始先走k步，之后设置一个指针last指向头，
        双指针同步走，当head走到末尾时，last指针与head指针距离就是k，因此last指针指向了最后k节点的头节点，返回即可
        细节在于，如果k很大，会出现无法找到的情况，需要特判
*/


public class Solution {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode last = pHead;
        while(k > 0 && pHead != null){
            k--;
            pHead = pHead.next;
        }
        if(k > 0) return null;
        while(pHead != null){
            pHead = pHead.next;
            last = last.next;
        }
        return last;
    }
}