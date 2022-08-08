package PS_2022.BOJ.Implementation.달력_20207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Before_Main {

    static class Schedule {
        int s, e;

        public Schedule(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Schedule> calender = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken()) + 1;
            calender.add(new Schedule(s, e));
        }

        Collections.sort(calender, (o1, o2) -> {
            if (o1.s == o2.s) return (o2.e - o2.s) - (o1.e - o1.s);
            return o1.s - o2.s;
        });

        Queue<Integer> pq = new PriorityQueue<>();
        int h = 0, start = 0, end = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Schedule s = calender.get(i);
            if(i == 0 || end < s.s) {
                ans += (end - start) * h;
                pq.clear();
                pq.add(s.e);
                start = s.s;
                end = s.e;
                h = 1;
                continue;
            }
            if(pq.peek() <= s.s) pq.poll();
            else h++;
            pq.add(s.e);
            end = Math.max(end, s.e);
        }
        ans += (end - start) * h;
        System.out.println(ans);
    }
}
