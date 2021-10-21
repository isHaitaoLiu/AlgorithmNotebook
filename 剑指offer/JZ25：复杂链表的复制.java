/*
    - 题目描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
              请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）。 
              下图是一个含有5个结点的复杂链表。图中实线箭头表示next指针，虚线箭头表示random指针。为简单起见，指向null的指针没有画出。
    - 知识点：链表
    - 题目解析：对一个链表进行深复制，需要复制（新建）其所有节点，并复制其引用关系
    - 代码解析：
            三次单层循环
            第一次循环：复制其节点数据，每个复制的节点都挂在原节点的往后一个位置，为第二次循环做好准备
            第二次循环：复制其random引用关系，由于第一次循环的结果，可以得到，
                      新复制的节点的random引用是在原节点的random引用的后面一个位置（这里需要注意random引用的判空）
            第三次循环：将新复制的链表从原链表中提取出来，即处理next引用关系
*/


public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        RandomListNode dummy = new RandomListNode(0), ncur = dummy, pcur = pHead;
        while(pcur != null){
            RandomListNode clone = new RandomListNode(pcur.label);
            clone.next = pcur.next;
            pcur.next = clone;
            pcur = clone.next;
        }
        pcur = pHead;
        while(pcur != null){
            if(pcur.random != null){
                pcur.next.random = pcur.random.next;
            }
            pcur = pcur.next.next;
        }
        pcur = pHead;
        while(pcur != null){
            ncur.next = pcur.next;
            ncur = ncur.next;
            pcur.next = pcur.next.next;
            pcur = pcur.next;
        }
        return dummy.next;
    }
}