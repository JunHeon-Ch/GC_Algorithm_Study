package 프로그래머스.level2.캐시;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int t = 0;
        for(String city : cities) {
            city = city.toLowerCase();
            if(queue.contains(city)) {
                t++;
                queue.remove(city);
                queue.add(city);
            }
            else {
                t += 5;
                queue.add(city);
                if(queue.size() > cacheSize) queue.poll();
            }
        }
        return t;
    }
}