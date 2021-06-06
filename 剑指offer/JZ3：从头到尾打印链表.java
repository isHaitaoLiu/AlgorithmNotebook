/*
    - 知识点：栈的应用；递归应用
    - 题目解析：无
    - 代码解析
        - 栈应用版：逐个取出链表元素并push到栈中，最后依次弹出并放入结果中即可
        - 递归版：递归出口为链表节点null，递归体内先进行递归操作，再往结果集中添加元素；则返回时，就会先添加元素，再进行递归返回
*/


import java.util.*;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<Integer> stack = new ArrayDeque<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}

import java.util.*;
public class Solution {
    //
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res;
        if(listNode == null){
            res = new ArrayList<>();
            return res;
        }
        res = printListFromTailToHead(listNode.next);
        res.add(listNode.val);
        return res;
    }
}