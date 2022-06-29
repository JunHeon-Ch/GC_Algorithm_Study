package PS_2021.프로그래머스.level2.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        boolean[] end = new boolean[progresses.length];
        int[] now = Arrays.copyOf(progresses, progresses.length);
        int remain = end.length;
        int first = 0;
        while(remain > 0) {
            for(int i = first; i < end.length; i++) {
                if(end[i]) continue;
                now[i] += speeds[i];
                if(now[i] >= 100) {
                    end[i] = true;
                }
            }
            if(end[first]) {
                int next;
                for(next = first; next < end.length; next++) {
                    if(!end[next]) break;
                }
                list.add(next - first);
                remain -= next - first;
                first = next;
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}