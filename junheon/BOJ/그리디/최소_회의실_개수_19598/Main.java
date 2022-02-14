package BOJ.그리디.최소_회의실_개수_19598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Time> times = new PriorityQueue<>((o1, o2) -> {
            if(o1.s == o2.s) return o1.e - o2.e;
            return o1.s - o2.s;
        });
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times.add(new Time(s, e));
        }

        PriorityQueue<Integer> end = new PriorityQueue<>();
        while(!times.isEmpty()) {
            Time cur = times.poll();
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
