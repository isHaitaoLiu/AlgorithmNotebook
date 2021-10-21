/*
    - 题目描述：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    - 知识点：排列、回溯
    - 题目解析：
        
    - 代码解析：
*/




class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def"); 
        map.put('4', "ghi"); 
        map.put('5', "jkl"); 
        map.put('6', "mno"); 
        map.put('7', "pqrs");
        map.put('8', "tuv"); 
        map.put('9', "wxyz"); 
        backtrack(digits, 0, res, map, new StringBuilder());
        return res;
    }

    public void backtrack(String digits, int idx, List<String> cur, HashMap<Character, String> map, StringBuilder sb){
        if(idx == digits.length()){
            cur.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(idx));
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            backtrack(digits, idx + 1, cur, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}