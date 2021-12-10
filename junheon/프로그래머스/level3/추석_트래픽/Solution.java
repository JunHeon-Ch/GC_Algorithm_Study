package 프로그래머스.level3.추석_트래픽;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/17676
 * 알고리즘: 누적합
 * 구간 문제는 누적합으로 풀어라

 * 시간복잡도: 3600 * 1000 * 24
 */
class Solution {
    public int solution(String[] lines) {
        // 최대 시간으로 사이즈 설정
        int[] acc = new int[3600 * 1000 * 24 + 1];
        for (String line : lines) {
            line = line.replace("2016-09-15 ", "");
            line = line.replace("s", "");
            StringTokenizer st = new StringTokenizer(line);
            String time = st.nextToken();
            int dur = (int) (Double.parseDouble(st.nextToken()) * 1000);
            st = new StringTokenizer(time, ":");
            // 종료 시간
            int e = (int) ((Double.parseDouble(st.nextToken()) * 3600 +
                    Double.parseDouble(st.nextToken()) * 60 +
                    Double.parseDouble(st.nextToken())) * 1000);
            // 1000ms간 처리하는 요청이기 때문에
            // 시작 시간 = 시작 시간 - 999
            int s = Math.max(e - (dur - 1) - 999, 0);
            acc[s]++;
            acc[e + 1]--;
        }
        // 누적합 계산
        int answer = acc[0];
        for (int i = 1; i < 3600 * 1000 * 24; i++) {
            acc[i] += acc[i - 1];
            answer = Math.max(answer, acc[i]);
        }
        return answer;
    }
}