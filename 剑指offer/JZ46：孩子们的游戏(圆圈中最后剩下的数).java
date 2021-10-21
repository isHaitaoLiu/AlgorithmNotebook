/*
    - 题目描述：
            每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
            其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
            每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
            继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
            请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
    - 知识点：数学
    - 题目解析：
            设置一个队列，先让所有小朋友入队；
            循环，直到队列只有一个小朋友：
                前m - 1个出队，出队后立即入队
                第m个出队，不入队
            最后剩下的即可得到大奖
    - 代码解析：
*/

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1) return -1;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i <= n - 1; i++){
            queue.offer(i);
        }
        while(queue.size() != 1){
            for(int i = 0; i < m - 1; i++){
                int cur = queue.poll();
                queue.offer(cur);
            }
            queue.poll();
        }
        return queue.peek();
    }
}