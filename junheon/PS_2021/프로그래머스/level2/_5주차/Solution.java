package PS_2021.프로그래머스.level2._5주차;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(String word) {
        char[] v = "AEIOU".toCharArray();
        Queue<String> q = new PriorityQueue<>();
        char[] w = new char[5];
        for(int a = 0; a < 5; a++) {
            w[0] = v[a];
            q.offer(new String(w, 0, 1));
            for(int b = 0; b < 5; b++) {
                w[1] = v[b];
                q.offer(new String(w, 0, 2));
                for(int c = 0; c < 5; c++) {
                    w[2] = v[c];
                    q.offer(new String(w, 0, 3));
                    for(int d = 0; d < 5; d++) {
                        w[3] = v[d];
                        q.offer(new String(w, 0, 4));
                        for(int e = 0; e < 5; e++) {
                            w[4] = v[e];
                            q.offer(new String(w, 0, 5));
                        }
                    }
                }
            }
        }
        int answer = 0;
        for(String s : q) {
            answer++;
            if(s.equals(word)) break;
        }

        return answer;
    }
}