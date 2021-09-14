package 푼문제;

import java.util.*;

public class 문제3 {
    public static void main(String[] args) {
        int[][] jobs = {{1, 5, 2, 3}, {2, 2, 3, 2}, {3, 1, 3, 3}, {5, 2, 1, 5}, {7, 1, 1, 1}, {9, 1, 1, 1}, {10, 2, 2, 9}};


        int index = 0;
        PriorityQueue<work> pq = new PriorityQueue<>();
        ArrayList<work> queue = new ArrayList<>();
        while (true) {
            work work = new work(jobs[index]);
            queue.add(work);

            int[] number = new int[101];
            for (work w : queue) {
                
            }

            index++;
        }
    }

    static class work {
        int start, time, type, rank;

        public work(int[] job) {
            this.start = job[0];
            this.time = job[1];
            this.type = job[2];
            this.rank = job[3];
        }
    }
}