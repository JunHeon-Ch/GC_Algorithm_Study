package PS_2021.프로그래머스.level2.프린터;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            q.offer(priorities[i]);
        }
        int loc = location;
        int ans = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            if(q.stream().anyMatch(i -> now < i)) {
                q.offer(now);
            } else {
                ans++;
                if(loc == 0) break;
            }
            if(loc == 0) loc = q.size() - 1;
            else loc--;
        }
        return ans;
    }
}
