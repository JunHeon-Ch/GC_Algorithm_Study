package PS_2021.BOJ.그리디.파일_합치기3_13975;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/13975
 * 알고리즘: 그리디(우선순위큐)
 * 시간복잡도: O(nlogn), n=1,000,000(소설을 구성하는 장의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            Queue<Long> pq = new PriorityQueue<>();
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(k-- > 0) pq.add(Long.parseLong(st.nextToken()));

            long ans = 0;
            while(pq.size() > 1) {
                long n1 = pq.poll();
                long n2 = pq.poll();
                ans += n1 + n2;
                pq.add(n1 + n2);
            }
            bw.write(ans + "\n");
        }
        bw.flush();
    }
}
