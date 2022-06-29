package PS_2021.프로그래머스.level2.더_맵게;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
        }

        while(queue.size() > 1) {
            if(queue.peek() >= K) break;
            int elem1 = queue.poll();
            int elem2 = queue.poll();
            queue.offer(elem1 + elem2 * 2);
        }

        if(queue.size() == 1 && queue.peek() < K) return -1;
        else return scoville.length - queue.size();
    }
}

