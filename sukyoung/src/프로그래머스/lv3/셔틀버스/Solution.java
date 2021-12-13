package 프로그래머스.lv3.셔틀버스;

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(String times: timetable){
            String[] time = times.split(":");
            queue.add(Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]));
        }

        int start = 9 * 60, finish = 0;
        int cnt = 0;
        for(int i=0; i<n; i++){
            cnt = 0;
            while(!queue.isEmpty()){
                int now = queue.peek();
                if(now <= start && cnt < m){
                    queue.poll();
                    cnt++;
                }
                else
                    break;
                finish = now - 1;
            }
            start += t;
        }
        if(cnt < m) finish = start - t;

        String hour = String.format("%02d", finish / 60);
        String minute = String.format("%02d", finish % 60);
        return hour + ":" + minute;
    }
}
