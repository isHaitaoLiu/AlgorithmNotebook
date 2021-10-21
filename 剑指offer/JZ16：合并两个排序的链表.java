/*
    - 题目描述：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    - 知识点：链表、排序
    - 题目解析：
    - 代码解析：
        设置一个新的虚拟节点，方便节点挂载，两链表指针都为空时结束循环
        如果链表2为空，或者都不为空且链表1元素小于链表2元素，则链表1节点挂到新链表上；
        如果链表1为空，或者都不为空且链表2元素小于链表1元素，则链表1节点挂到新链表上；
*/




public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(list1 != null || list2 != null){
            if(list2 == null || (list1 != null && list1.val <= list2.val)){
                pre.next = list1;
                list1 = list1.next;
                pre = pre.next;
            }
            else if(list1 == null || (list2 != null && list2.val <= list1.val)){
                pre.next = list2;
                list2 = list2.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}