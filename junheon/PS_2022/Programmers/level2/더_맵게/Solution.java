package PS_2022.Programmers.level2.더_맵게;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42626
 * 알고리즘: 힙
 * 시간복잡도: O(nlogn), n=1,000,000(scoville의 길이)
 */
class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        int answer = 0;
        while(true) {
            if(pq.size() == 1) break;
            int n1 = pq.poll();
            int n2 = pq.poll();
            if(n1 >= K) break;
            pq.add(n1 + n2 * 2);
            answer++;
        }
        if(pq.size() == 1 && pq.peek() < K) return -1;
        return answer;
    }
}