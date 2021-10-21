/*
    - 题目描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
              有效字符串需满足：
              左括号必须用相同类型的右括号闭合。
              左括号必须以正确的顺序闭合。
    - 知识点：栈的应用
    - 题目解析：
            入栈、出栈匹配即可
    - 代码解析：
*/


class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '(' || c == '['){
                stack.push(c);
            }else{
                if(c == '}'){
                    if(stack.isEmpty() || stack.peek() != '{') return false;
                    else stack.pop();
                }
                if(c == ')'){
                    if(stack.isEmpty() || stack.peek() != '(') return false;
                    else stack.pop();
                }
                if(c == ']'){
                    if(stack.isEmpty() || stack.peek() != '[') return false;
                    else stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}