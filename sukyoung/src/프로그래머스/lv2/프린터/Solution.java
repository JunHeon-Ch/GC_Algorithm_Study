package 프로그래머스.lv2.프린터;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priority_queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: priorities)
            priority_queue.add(i);

        while(!priority_queue.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priority_queue.peek() == priorities[i]){
                    priority_queue.poll();
                    answer ++;
                    if(location == i){
                        priority_queue.clear();
                        break;
                    }
                }
            }
        }
        return answer;
    }
}