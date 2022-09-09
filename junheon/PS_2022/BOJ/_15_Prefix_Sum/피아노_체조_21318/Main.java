package PS_2022.BOJ._15_Prefix_Sum.피아노_체조_21318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/21318
 * 알고리즘: 누적합
 * 시간복잡도: O(m), m=100,000(질문의 개수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cum = new int[n + 1];
        int prev = Integer.parseInt(st.nextToken());
        for(int i = 2; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(prev > num) cum[i - 1] = 1;
            prev = num;
        }
        for(int i = 2; i <= n; i++) {
            cum[i] += cum[i - 1];
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append((cum[e - 1] - cum[s - 1]) + "\n");
        }
        System.out.println(sb.toString());
    }
}
