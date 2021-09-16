package 푼문제;

import java.util.*;

public class 무지의먹방라이브 {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;

        List<Pair> foods = new LinkedList<>();
        int n = food_times.length;

        for (int i = 0; i < n; i++) {
            foods.add(new Pair(food_times[i], i + 1));
        }

        foods.sort(compareTime);

        int preTime = 0;
        int i = 0;

        for (Pair f : foods) {
            long dif = f.time - preTime;
            if (dif != 0) {
                long spend = dif * n;
                if (spend <= k) {
                    k -= spend;
                    preTime = f.time;
                } else {
                    k %= n;
                    foods.subList(i, food_times.length).sort(compareIdx);
                    System.out.println(foods.get(i + (int) k).idx);
                }
            }
            ++i;
            --n;
        }
        System.out.println(-1);

    }

    static class Pair {
        int idx, time;

        public Pair(int time, int idx) {
            this.idx = idx;
            this.time = time;
        }

    }

    static Comparator<Pair> compareTime = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.time - o2.time;
        }
    };
    static Comparator<Pair> compareIdx = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.idx - o2.idx;
        }
    };

}
