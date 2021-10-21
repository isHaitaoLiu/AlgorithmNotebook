/*
    - 题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
        保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。
    - 知识点：数学运算，快速幂
    - 题目解析：
    - 代码解析：
        先将倍数变为正数。原倍数如果是负数，结果变为倒数；原倍数如果是正数，结果保持不变。
        假设倍数为n，则通过cur不断乘2得到一个最大的不超过n的2次幂，base与此同时不断乘2；
        n - 2^x 得到一个新的n，重复上述；可快速得到一个结果。
*/


```
public class Solution {
    public double Power(double base, int exponent) {
        if(exponent == 0) return 1;
        boolean flag = true;
        int pow = exponent;
        if(exponent < 0){
            flag = false;
            exponent = -exponent;
        }
        double res = 1;
        while(exponent > 0){
            int cur = 1;
            double temp = base;
            while(cur * 2 <= exponent){
                cur = cur * 2;
                temp = temp * temp;
            }
            exponent -= cur;
            res *= temp;
        }
        res = flag == true ? res : (1/res);
        return res;
  }
}
```