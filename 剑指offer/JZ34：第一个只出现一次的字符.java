/*
    - 题目描述：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 
              如果没有则返回 -1（需要区分大小写）.（从0开始计数）
    - 知识点：字符串、哈希表
    - 题目解析：
        （1）法1：两次扫描字符串，第一次分别记录字符的个数，放入到HashMap中；第二次扫描，找出只出现1次的返回，没有则返回-1
        （2）法二：第一次扫描字符串，记录字符出现的个数以及出现的位置；之后扫描HashMap，返回只出现一次且位置最小的一个
    - 代码解析：
*/



public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, int[]> map = new HashMap<Character, int[]>();
        for(int i = 0; i < str.length(); i++){
            int[] pair = map.getOrDefault(str.charAt(i), new int[]{0, i});
            pair[0] += 1;
            map.put(str.charAt(i), pair);
        }
        int res = Integer.MAX_VALUE;
        for(int[] pair: map.values()){
            if(pair[0] == 1 && pair[1] < res){
                res = pair[1];
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}