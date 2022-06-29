package PS_2021.BOJ.그리디.강의실_배정_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/11000
 * 알고리즘: 그리디, 우선순위큐
 * 시간복잡도: O(n), n=200,000(n 최대값)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Time> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.s == o2.s) return o1.e - o2.e;
            return o1.s - o2.s;
        });
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Time(s, e));
        }

        PriorityQueue<Integer> end = new PriorityQueue<>();
        while(!pq.isEmpty()) {
            Time cur = pq.poll();
            if(!end.isEmpty() && end.peek() <= cur.s) end.poll();
            end.add(cur.e);
        }
        System.out.println(end.size());
    }

    static class Time {
        int s, e;

        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
