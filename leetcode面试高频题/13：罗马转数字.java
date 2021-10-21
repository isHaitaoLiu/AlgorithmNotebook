/*
    - 题目描述：罗马数字转阿拉伯数字
    - 知识点：双指针
    - 题目解析：
            HashMAp简单应用
    - 代码解析：
*/

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i + 1 < s.length()){
                char nc = s.charAt(i + 1);
                if((c == 'I' && (nc == 'V' || nc == 'X')) || (c == 'X' && (nc == 'L' || nc == 'C')) || (c == 'C' && (nc == 'D' || nc == 'M'))){
                    res -= map.get(c);
                    continue;
                }
            }
            res += map.get(c);
        }
        return res;
    }
}