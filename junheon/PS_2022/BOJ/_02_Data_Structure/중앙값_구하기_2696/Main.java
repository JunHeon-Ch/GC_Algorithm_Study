package PS_2022.BOJ._02_Data_Structure.중앙값_구하기_2696;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2696
 * 알고리즘: 우선순위큐
 * 시간복잡도: O(m*nlogn), m=1,000(테스트케이스 개수), n=10,000(수열 크기)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int m = Integer.parseInt(br.readLine());
            int n = (int) Math.ceil((double) m / 10);
            int cnt = 1;
            bw.write((m + 1) / 2 + "\n");
            Queue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
            Queue<Integer> min = new PriorityQueue<>();
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    m--;
                    if (m % 2 == 0) max.add(num);
                    else min.add(num);

                    if(!min.isEmpty() && max.peek() > min.peek()) {
                        int n1 = max.poll();
                        int n2 = min.poll();
                        max.add(n2);
                        min.add(n1);
                    }
                    if(m % 2 == 0) {
                        if(cnt == 10 || m == 0) {
                            bw.write(max.peek() + "\n");
                            cnt = 1;
                        } else {
                            bw.write(max.peek() + " ");
                            cnt++;
                        }
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
