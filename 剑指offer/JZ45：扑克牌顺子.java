/*
    - 题目描述：
            现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
            有如下规则：
            1. A为1，J为11，Q为12，K为13，A不能视为14
            2. 大、小王为 0，0可以看作任意牌
            3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
            例如：给出数据[6,0,2,0,4]
            中间的两个0一个看作3，一个看作5 。即：[6,3,2,5,4]
            这样这五张牌在[2,6]区间连续，输出true
            数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
    - 知识点：？
    - 题目解析：
           如果数组中所有非0的牌，满足【最大值 - 最小值 < 5】，那么这些牌要么有0，要么重复；
           在这样的情况下，如果没有重复，则说明可以凑成一个顺子，因为0可以当作任意一个数
           所以，计算非0的最大值最小值，同时判断有无重复，最后判断最大最小值的差值即可得出结果
    - 代码解析：
*/

public class Solution {
    public boolean IsContinuous(int [] numbers) {
        int min = 14, max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int val : numbers){
            if(val > 0){
                if(set.contains(val)){
                    return false;
                }
                set.add(val);
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }
        return max - min < 5 ? true : false;
    }
}