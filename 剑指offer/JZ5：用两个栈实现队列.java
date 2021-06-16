/*
    - 题目：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    - 知识点：栈、队列
    - 题目解析：把一个栈的栈底看作队头，一个栈的栈底看作队尾即可
    - 代码解析：
        - 根据题目解析，把s1栈底看作队头，s2栈底看作队尾
        - 入队时需要找到队尾，因此将s2的元素全部放入s1中，这样s1栈顶暴露的是s2的栈底，也就是队尾，入栈即入队
        - 出队时需要找到队头，因此将s1的元素全部放入s2中，这样s2栈顶暴露的是s1的栈底，也就是队头，出栈即出队
*/

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }
    
    public int pop() {
       while(!stack1.isEmpty()){
           stack2.push(stack1.pop());
       }
       return stack2.pop();
    }
}