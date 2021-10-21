/*
    - 题目描述：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    - 知识点：滑动窗口
    - 题目解析： 维护一个滑动窗口，窗口内的字符存储在set里面，每轮循环滑动右区间，如果右区间当前字符已经存在于set，
               则表示出现重复，则滑动左区间，直到窗口内无重复；窗口内无重复时，更新结果
    - 代码解析： 
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r = 0, l = 0, res = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()){
            char c = s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(r - l + 1, res);
            r++;
        }
        return res;
    }
}