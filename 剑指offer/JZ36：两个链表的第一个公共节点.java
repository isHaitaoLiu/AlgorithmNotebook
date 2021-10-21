/*
    - 题目描述：输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，
              所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
    - 知识点：链表
    - 题目解析：
           先计算两个链表的长度len1，len2，设置指针分别指向两个链表头部，让长的链表指针先走len1,len2的差值步，
           之后两个指针同步向前走，就可以找到公共节点
    - 代码解析：
*/


public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1, cur2 = pHead2;
        int len1 = 0, len2 = 0;
        while(cur1 != null){
            cur1 = cur1.next;
            len1++;
        }
        while(cur2 != null){
            cur2 = cur2.next;
            len2++;
        }
        cur1 = pHead1;
        cur2 = pHead2;
        if(len1 > len2){
            while(len1 > len2){
                cur1 = cur1.next;
                len1--;
            }
        }
        else{
            while(len2 > len1){
                cur2 = cur2.next;
                len2--;
            }
        }
        while(cur1 != null){
            if(cur1 == cur2) return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}