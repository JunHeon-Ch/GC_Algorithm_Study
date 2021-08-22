package 프로그래머스.level2.기능개발;

import java.util.Arrays;

class Best_Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfEnd = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfEnd[day]++;
        }
        return Arrays.stream(dayOfEnd).filter(i -> i!=0).toArray();
    }
}