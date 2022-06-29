package PS_2021.프로그래머스.level3.이중우선순위큐;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42628
 * 알고리즘: 힙
 * priority queue 2개 써서 구현
 * 시간복잡도: O(nlogn), n=1,000,000
 * priority queue의 add, remove 둘 다 O(logn)
 */

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(op.equals("I")) {
                maxHeap.add(num);
                minHeap.add(num);
            } else if(op.equals("D")) {
                if(num == 1 && !maxHeap.isEmpty()) minHeap.remove(maxHeap.poll());
                else if(num == -1 && !minHeap.isEmpty()) maxHeap.remove(minHeap.poll());
            }
        }
        if(maxHeap.isEmpty() || minHeap.isEmpty()) return new int[]{0, 0};
        else return new int[]{maxHeap.poll(), minHeap.poll()};
    }
}