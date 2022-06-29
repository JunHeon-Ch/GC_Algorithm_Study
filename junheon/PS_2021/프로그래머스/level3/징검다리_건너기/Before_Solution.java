package PS_2021.프로그래머스.level3.징검다리_건너기;

import java.util.*;

/*
 * 슬라이딩 윈도우 + 힙 풀이
 * O(nlogn)인데 왜 시간 초과인지 모르겠음
 */
class Before_Solution {

    public int solution(int[] stones, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            deque.addLast(i);
            queue.add(stones[i]);
            if (i >= k) {
                int idx = deque.removeFirst();
                queue.remove(stones[idx]);
            }
            if(queue.size() == k) answer = Math.min(answer, queue.peek());
        }
        return answer;
    }
}