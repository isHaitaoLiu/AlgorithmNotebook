/*
    - 题目描述：牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
              同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
              例如，“nowcoder. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
              正确的句子应该是“I am a nowcoder.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
    - 知识点：字符串
    - 题目解析：
        （1）库函数 split()分割空格，之后从后往前遍历即可
        （2）模范库函数方法，ArrayList存储一个个单词，反向遍历append
    - 代码解析：
*/


public class Solution {
    public String ReverseSentence(String str) {
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--){
            sb.append(strs[i]);
            if(i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}