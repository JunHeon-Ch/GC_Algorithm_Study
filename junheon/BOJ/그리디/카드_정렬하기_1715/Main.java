package BOJ.그리디.카드_정렬하기_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://www.acmicpc.net/problem/1715
 * 알고리즘: 그리디(우선순위큐)
 * 시간복잡도: O(nlogn), n=100,000(카드 묶음의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        while(n-- > 0) pq.add(Integer.parseInt(br.readLine()));

        int ans = 0;
        while(pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            ans += n1 + n2;
            pq.add(n1 + n2);
        }
        System.out.println(ans);
    }
}
