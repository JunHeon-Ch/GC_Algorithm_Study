package PS_2021.프로그래머스.level3.단속카메라;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42884
 * 알고리즘: 그리디
 * 시간복잡도: O(nlogn), n=10,000(routes 배열 길이)
 */

class Solution {
    public int solution(int[][] routes) {
        int n = routes.length;
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]); // 진입 지점 기준 소팅
        int answer = 0;
        int i = 0;
        while(i < n) {
            int s = routes[i][0];
            int e = routes[i][1];
            int j = i + 1;
            while(j < n && s <= routes[j][0] && routes[j][0] <= e) {
                s = routes[j][0];
                e = Math.min(e, routes[j][1]);
                j++;
            }
            answer++;
            i = j;
        }
        return answer;
    }
}