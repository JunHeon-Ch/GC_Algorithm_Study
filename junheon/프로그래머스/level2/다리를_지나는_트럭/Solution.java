package 프로그래머스.level2.다리를_지나는_트럭;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> w = new LinkedList<>();
        Queue<Integer> t = new LinkedList<>();
        int i = 0, T = 1, total = 0, truck = 0;
        while(truck < truck_weights.length) {
            if(!t.isEmpty() && t.peek() <= T) {
                total -= w.poll();
                t.poll();
                truck++;
            }
            if(i < truck_weights.length && total + truck_weights[i] <= weight) {
                total += truck_weights[i];
                w.offer(truck_weights[i]);
                t.offer(T + bridge_length);
                i++;
            }
            T++;
        }
        return T - 1;
    }
}