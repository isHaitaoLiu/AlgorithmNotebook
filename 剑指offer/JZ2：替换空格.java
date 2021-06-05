/*
    知识点：字符串处理
    题目分析：无
    代码解析：
        - 新建一个StringBuilder，扫描源串。遇到' '，追加"%20"，否则追加源字符即可。
*/

public class Solution {
    public String replaceSpace (String s) {
        if(s == null) return null;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ') res.append(s.charAt(i));
            else res.append("%20");
        }
        return res.toString();
    }
}
