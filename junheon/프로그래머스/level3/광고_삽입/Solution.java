package 프로그래머스.level3.광고_삽입;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/72414
 * 알고리즘: 누적합
 * 시간복잡도: O(n), n=play_time을 초로 변환했을 때의 최대 길이(360,000)
 */

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = transform(play_time);
        long[] cum = new long[play + 1];
        for(int i = 0; i < logs.length; i++) {
            StringTokenizer st = new StringTokenizer(logs[i], "-");
            int s = transform(st.nextToken());
            int e = transform(st.nextToken());
            cum[s]++;
            cum[e]--;
        }
        for(int i = 1; i <= play; i++) {
            cum[i] += cum[i - 1];
        }
        for(int i = 1; i <= play; i++) {
            cum[i] += cum[i - 1];
        }

        int adv = transform(adv_time);
        long max = cum[adv - 1];
        int ans = 0;
        for(int i = 0; i + adv <= play; i++) {
            long res = cum[i + adv] - cum[i];
            if(max < res) {
                ans = i + 1;
                max = res;
            }
        }
        return String.format("%02d:%02d:%02d", ans / 3600, (ans % 3600) / 60, (ans % 3600) % 60);
    }

    public int transform(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        return Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
}