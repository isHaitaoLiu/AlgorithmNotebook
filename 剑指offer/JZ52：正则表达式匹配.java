/*
    - 题目描述：
    请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
    在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

    - 知识点：动态规划
    - 题目解析：
        dp[i][j] 数组来表示 字符串前i个字符与模式串前j个字符是否匹配
        （1）注意点1，当字符串和模式串长度都为0时，可以匹配
        （2）初始化，需要对字符串为空串的情况做一个初始化。注意到,*不可能在模式串的首位，因此遍历开始时，从模式串第二个位置开始，
        如果当前模式串字符为 *， 代表其是否可以匹配空串取决于，去掉两个字符后是否可匹配空串，即dp[0][i] = dp[0][i - 2]
        （3）逐步完善dp数组
            （I）s[i] = p[j] 或者 p[j] == '.'时，表示当前字符可以匹配，整个串是否可以匹配需要看前面的子串是否可以匹配
            （II）如果p[j] == '*',需要分情况
                    - 当p[j - 1] 不能匹配 s[i] 而且 p[j - 1]不是'.'时，则p[j - 1]和p[j]这两个字符只有在匹配0个字符时，
                    才有可能可以匹配上s，即查看dp[i][j - 2]
                    - 当p[j - 1] 能匹配 s[i] 或者 p[j - 1]是'.'时，则p[j - 1]和p[j]这两个字符可以匹配 0个或多个字符，
                    得到dp[i][j - 2]   dp[i - 1][j]
                    - 值得注意的是dp[i - 1][j]可以代表匹配1个2个3个....，因为如果s有连续的串，
                    将继续满足p[j - 1] 能匹配 s[i - 1] 或者 p[j - 1]是'.'.....依此类推
    - 代码解析：
*/


public class Solution {
    public boolean match (String str, String pattern) {
        if(str == null || pattern == null) return false;
        int m = str.length(), n = pattern.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        int[] s = new int[m + 1];
        int[] p = new int[n + 1];
        s[0] = '0';
        p[0] = '0';
        for(int i = 1; i <= m; i++){
            s[i] = str.charAt(i - 1);
        }
        for(int i = 1; i <= n; i++){
            p[i] = pattern.charAt(i - 1);
        }
        dp[0][0] = true;
        for(int i = 2; i <= n; i++){
            if(p[i] == '*' && dp[0][i - 2] == true){
                dp[0][i] = true;
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s[i] == p[j] || p[j] == '.') dp[i][j] = dp[i - 1][j - 1];
                else if(p[j] == '*'){
                    if(s[i] != p[j - 1] && p[j - 1] != '.'){
                        dp[i][j] = dp[i][j - 2];
                    }else{
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}