/*
    - 题目描述：输入一个字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
              例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    - 知识点：递归、回溯、排列组合
    - 题目解析：一个字符串的所有排列方式
    - 代码解析：
        排列组合通常使用回溯法，得到一个候选集合，依次尝试将字符放进去。
        例如 aabcd第一次尝试得到[a], b, c, d
        a开头得到  [aa], ab, ac, ad
        之后 aab, aac, aad...依此类推
        需要注意的是：（1）如果已经访问过的元素，则不再尝试；
        （2）如果出现 aaaaa类似的重复，那么在访问过第一个a后，a,aa,aaa,aaaa,aaaaa都已经出现过，不应该再出现类似的排列，
        因此，如果visited[i - 1] == false且strs[i - 1] == strs[i]就可以跳过了
*/


public class Solution {
    public ArrayList<String> Permutation(String str) {
        char[] strs = str.toCharArray();
        Arrays.sort(strs);
        ArrayList<String> res = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        boolean[] visited = new boolean[strs.length];
        backtrack(res, tmp, strs, visited);
        return res;
    }
    
    public void backtrack(ArrayList<String> res, StringBuilder tmp, char[] strs, boolean[] visited){
        if(tmp.length() == strs.length){
            res.add(tmp.toString());
        }else{
            for(int i = 0; i < strs.length; i++){
                if(visited[i] == true) continue;
                if(i > 0 && strs[i] == strs[i - 1] && visited[i - 1] == false) continue;
                visited[i] = true;
                tmp.append(strs[i]);
                
                backtrack(res, tmp, strs, visited);
                
                tmp.deleteCharAt(tmp.length() - 1);
                visited[i] = false;
            }
        }
    }
}