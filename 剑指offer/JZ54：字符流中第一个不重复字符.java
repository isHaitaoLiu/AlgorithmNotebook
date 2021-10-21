/*
    - 题目描述：
        请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
        后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
        string caseout = "";
        1.读入测试用例字符串casein
        2.如果对应语言有Init()函数的话，执行Init() 函数
        3.循环遍历字符串里的每一个字符ch {
        Insert(ch);
            caseout += FirstAppearingOnce()
        }
        2. 输出caseout，进行比较。
    - 知识点：字符串
    - 题目解析：
            每次插入时，HashMap记录字符出现次数，以及第一次插入时字符的索引
            查找时，遍历HashMap，找到只出现一次且索引最小的字符即可返回
    - 代码解析：
*/


public class Solution {
    //Insert one char from stringstream
    int idx = 0;
    HashMap<Character, Integer[]> map = new HashMap<>();
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            Integer[] value = map.get(ch);
            value[1]++;
            map.put(ch, value);
        }else{
            Integer[] value = new Integer[2];
            value[0] = idx;
            value[1] = 1;
            map.put(ch, value);
        }
        idx++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char res = '#';
        int cur = Integer.MAX_VALUE;
        for(Character c : map.keySet()){
            Integer[] value = map.get(c);
            if(value[1] == 1 && value[0] < cur){
                cur = value[0];
                res = c;
            }
        }
        return res;
    }
}