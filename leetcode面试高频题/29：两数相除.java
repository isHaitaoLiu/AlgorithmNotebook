/*
    - 题目描述：给给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
              返回被除数 dividend 除以除数 divisor 得到的商。
    - 知识点：数学
    - 题目解析：
        （1）特殊情况处理：先考虑特殊情况，即结果溢出，只有当负数最大值/-1时才会发生溢出
        （2）数据预处理：为了方便计算，需要把被除数和除数都转为相同符号的数。而正数表示范围没有负数那么大，负数转为正数有可能溢出，所以把正数转为负数，最后结果再加上符号
        （3）主逻辑：
            【1】现在得到up被除数和down除数两个数，且都是负数
            【2】最容易思考的结局方案就是 up - down - down - down...每次减去一个down，累加计数，直到up不够减；但这样花费的时间显然太长，解决方案就是利用指数爆炸的特性，让down每次都变成2倍，再尝试 up - down的可行性，就可以很快进行计算了，当发现up不够减的时候，down又从一倍开始累乘。
            【3】需要注意的一点是，down 不能超过了负数的边界，需要 >= -(1 << 31)，因此在变为2倍之前，需要 >= -(1 << 30)

    - 代码解析：
*/



class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int up = dividend > 0 ? -dividend : dividend;
        int down = divisor > 0 ? -divisor : divisor;
        int res = 0;
        while(up <= down){
            int counter = 1, base = down;
            while(base >= -(1 << 30) && up <= (base << 1)){
                counter = counter << 1;
                base = base << 1;
            }
            res += counter;
            up -= base;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
}