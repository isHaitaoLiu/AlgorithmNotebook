/*
    - 题目描述：小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
            但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
            他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 
            输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
    - 知识点：滑动窗口
    - 题目解析：
            维护滑动窗口的左右指针l,r和窗口内的和cur;
            如果窗口内的和cur = sum, 则将l-r的所有数字加入结果集合；
            如果窗口内的和cur >= sum, 则移动左指针；
            否则移动右指针
    - 代码解析：
*/



public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int l = 1, r = 2;
        int cur = 1;
        while(r < sum){
            cur += r;
            while(cur >= sum){
                if(cur == sum){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    for(int i = l; i <= r; i++){
                        tmp.add(i);
                    }
                    res.add(tmp);
                }
                cur -= l;
                l++;
            }
            r++;
        }
        return res;
    }
}