package 푼문제;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

        System.out.println(Arrays.stream(operations).mapToInt(k ->Integer.parseInt(k.substring(2))).sum());
        for (String str : operations) {
            char op = str.charAt(0);

            if (op == 'I') {
                pq1.add(Integer.parseInt(str.substring(2)));
                pq2.add(Integer.parseInt(str.substring(2)));
            } else if (op == 'D' && !pq1.isEmpty()) {
                if (str.charAt(2) == '1') {
                    int k = pq2.remove();
                    pq1.remove(k);
                } else {
                    int k = pq1.remove();
                    pq2.remove(k);
                }
            }
        }
        int[] answer = new int[2];
        if (pq1.isEmpty()) {
            return;
        }
        System.out.println(pq1.remove() + " " + pq2.remove());
    }
}
