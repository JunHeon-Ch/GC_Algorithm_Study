package PS_2021.프로그래머스.level3.단어_변환;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/43163
 * 알고리즘: BFS
 * 시간복잡도: O(m*n^2), m=10(단어의 길이), n=50(words 배열의 길이)
 */

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        int targetIdx = -1; // newWords 내의 target 값의 idx
        String[] newWords = new String[n + 1]; // begin str을 포함한 words
        newWords[0] = begin;
        for (int i = 1; i < n + 1; i++) {
            newWords[i] = words[i - 1];
            if (newWords[i].equals(target)) targetIdx = i;
        }

        int[] dist = new int[n + 1]; // 변환 횟수 저장
        Arrays.fill(dist, -1);

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        dist[0] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < n + 1; i++) {
                if (dist[i] != -1) continue;
                // 알파벳이 하나만 다를 경우 변환
                int cnt = 0;
                for (int k = 0; k < newWords[now].length(); k++) {
                    if (newWords[now].charAt(k) != newWords[i].charAt(k)) cnt++;
                    if (cnt > 1) break;
                }
                if (cnt == 1) {
                    q.add(i);
                    dist[i] = dist[now] + 1;
                }
            }
        }
        return targetIdx == -1 ? 0 : dist[targetIdx];
    }
}