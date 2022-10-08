package PS_2022.BOJ._02_Data_Structure.절대값_힙_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://www.acmicpc.net/problem/11286
 * 알고리즘: 우선순위큐
 * 시간복잡도: O(nlogn), n=100,000(연산의 개수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(queue.isEmpty()) sb.append("0\n");
                else sb.append(queue.poll() + "\n");
            } else queue.add(num);
        }
        System.out.println(sb.toString());
    }
}
