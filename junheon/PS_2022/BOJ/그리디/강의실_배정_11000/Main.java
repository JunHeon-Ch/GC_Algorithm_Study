package PS_2022.BOJ.그리디.강의실_배정_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/11000
 * 알고리즘: 그리디
 * 시간복잡도: O(nlogn), n=200,000(수업의 수)
 */

public class Main {

    static class Time {
        int s, e;

        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        Time[] time = new Time[len];
        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            time[i] = new Time(s, e);
        }
        Arrays.sort(time, (o1, o2) -> {
            if (o1.s == o2.s) return o1.e - o2.e;
            return o1.s - o2.s;
        });

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(time[0].e);
        for (int i = 1; i < len; i++) {
            if(room.peek() <= time[i].s) room.poll();
            room.add(time[i].e);
        }
        System.out.println(room.size());
    }
}
