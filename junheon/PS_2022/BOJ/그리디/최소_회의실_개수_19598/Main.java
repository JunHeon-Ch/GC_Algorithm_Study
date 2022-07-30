package PS_2022.BOJ.그리디.최소_회의실_개수_19598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/19598
 * 알고리즘: 그리디
 * 시간복잡도: O(nlogn), n=100,000(회의의 수)
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
        Time[] times = new Time[len];
        for(int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times[i] = new Time(s, e);
        }
        Arrays.sort(times, (o1, o2) -> {
            if(o1.s == o2.s) return o1.e - o2.e;
            return o1.s - o2.s;
        });

        Queue<Integer> room = new PriorityQueue<>();
        room.add(times[0].e);
        for(int i = 1; i < len; i++) {
            if(room.peek() <= times[i].s) room.poll();
            room.add(times[i].e);
        }
        System.out.println(room.size());
    }
}
