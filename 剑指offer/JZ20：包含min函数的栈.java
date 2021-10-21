/*
    - 题目描述：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，
                并且调用 min函数、push函数 及 pop函数 的时间复杂度都是 O(1)
    - 知识点：栈、最小栈
    - 题目解析：实现一个最小栈，min函数获取栈最小值，时间复杂度O(1)
    - 代码解析：
        内部设置两个栈：普通栈和min栈
        push : 如果栈无元素或者当前元素大于min栈的栈顶，说明当前元素入栈或出栈不影响当前最小值，所以把min栈栈顶元素再压入栈一遍
        pop: 两个栈都出
        top: 获取普通栈栈顶
        min: 获取min栈栈顶
*/


public class Solution {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> subStack = new ArrayDeque<>();
     
    public void push(int node) {
        if(subStack.isEmpty() || subStack.peek() > node){
            subStack.push(node);
        }
        else{
            subStack.push(subStack.peek());
        }
        stack.push(node);
    }
     
    public void pop() {
        stack.pop();
        subStack.pop();
    }
     
    public int top() {
        return stack.peek();
    }
     
    public int min() {
        return subStack.peek();
    }
}