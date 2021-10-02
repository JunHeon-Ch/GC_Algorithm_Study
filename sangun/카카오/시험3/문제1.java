package 시험3;

import java.util.*;

public class 문제1 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[] v = {7,6,9,5,7};
        int a = 4;
        int b = 1;

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int k : v) {
            pq.add(k);
        }
        int peek = pq.poll();
        while (peek >= 0) {

            answer++;
            peek -= a;
            if(peek<0)break;
            List<Integer> list = new ArrayList<>();
            list.add(peek);
            boolean flag = false;
            while (!pq.isEmpty()) {
                int value = pq.poll() - b;
                if (value < 0) {
                    flag = true;
                    break;
                }
                list.add(value);
            }
            System.out.println(list);
            if (flag) break;
            pq = new PriorityQueue<>(Comparator.reverseOrder());
            pq.addAll(list);
            peek = pq.poll();
        }


        System.out.println(answer-1);

    }

}
