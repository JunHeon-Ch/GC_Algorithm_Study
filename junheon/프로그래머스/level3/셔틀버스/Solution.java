package 프로그래머스.level3.셔틀버스;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/17678
 * 알고리즘: 소팅, 구현
 */
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] tt = new int[timetable.length];
        int i = 0;
        for(String time : timetable) {
            StringTokenizer st = new StringTokenizer(time, ":");
            tt[i++] = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tt);

        int time = 9 * 60;
        int cnt = 0, idx = 0;
        String answer = "";
        while(cnt < n) {
            // 현재 셔틀 도착 시간 이전에 대기한 사람 중 m명 탑승
            i = 0;
            while(i + idx < tt.length && tt[i + idx] <= time && i < m) i++;
            // 마지막 셔틀 운행
            if(cnt == n - 1) {
                int hour, min;
                if(i < m) { // m명이 채워지지 않을 경우
                    hour = time / 60;
                    min = time % 60;
                } else { // m명이 다 채워진 경우 -> 마지막 탑승자 시간-1
                    hour = (tt[i + idx - 1] - 1) / 60;
                    min = (tt[i + idx - 1] - 1) % 60;
                }
                answer += (hour < 10 ? "0" + hour : hour) + ":" + (min < 10 ? "0" + min : min);
            }
            idx += i;
            time += t;
            cnt++;
        }
        return answer;
    }
}

//import java.util.*;
//
//class Solution {
//    public String solution(int n, int t, int m, String[] timetable) {
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        for(String time : timetable) {
//            StringTokenizer st = new StringTokenizer(time, ":");
//            q.add(Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()));
//        }
//
//        int time = 9 * 60;
//        int cnt = 0;
//        String answer = "";
//        while(cnt < n) {
//            int i = 0;
//            int last = 0;
//            while(!q.isEmpty() && q.peek() <= time && i < m) {
//                last = q.poll();
//                i++;
//            }
//            if(cnt == n - 1) {
//                int hour, min;
//                if(i < m) {
//                    hour = time / 60;
//                    min = time % 60;
//                } else {
//                    hour = (last - 1) / 60;
//                    min = (last - 1) % 60;
//                }
//                answer += (hour < 10 ? "0" + hour : hour) + ":" + (min < 10 ? "0" + min : min);
//            }
//            time += t;
//            cnt++;
//        }
//        return answer;
//    }
//}