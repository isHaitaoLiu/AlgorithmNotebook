/*
    - 题目描述：
        如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
        如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
        我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
    - 知识点：堆
    - 题目解析：
        （1）优先级队列1记录最大的一半，优先级队列2记录最小的一半。如何记录，每次先入队列1，从队列1中出队一个，放入入队列2，如果
        队列大小差异了，再从队列2出队一个 放回队列1
        （2）按照队列大小是否有差异，以不同方式返回数据
    - 代码解析：
*/

public class Solution {
    PriorityQueue<Integer> hq = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> lq = new PriorityQueue<>();
    
    
    public void Insert(Integer num) {
        hq.offer(num);
        lq.offer(hq.poll());
        if(lq.size() > hq.size()) hq.offer(lq.poll());
    }

    public Double GetMedian() {
        return lq.size() == hq.size() ? (double)(hq.peek() + lq.peek()) / 2 : (double)hq.peek();
    }
}