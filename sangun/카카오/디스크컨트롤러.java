import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {2, 6}, {1, 9}};

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        LinkedList<Pair> waiting = new LinkedList<>();

        for (int i = 0; i < jobs.length; i++) {
            waiting.add(new Pair(jobs[i][0], jobs[i][1]));
        }
        waiting.sort(Comparator.comparingInt(o -> o.x));

        int answer = 0;
        int cnt = 0;
        int time = waiting.peek().x;

        while (cnt < jobs.length) {
            while (!waiting.isEmpty() && waiting.peek().x <= time) {
                pq.offer(waiting.pollFirst());
            }

            if (!pq.isEmpty()) {
                Pair job = pq.poll();
                time += job.y;
                answer += time - job.x;
                cnt++;
            } else {
                time++;
            }
        }
        System.out.println(answer / cnt);

    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.y, o.y);
        }
    }


}
