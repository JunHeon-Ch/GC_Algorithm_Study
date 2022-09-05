package PS_2022.BOJ.Prefix_Sum.출석체크_20438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/20438
 * 알고리즘: 누적합
 * 시간복잡도: O(n), n=50,000(구간의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] sleep = new boolean[n + 3];
        int[] cum = new int[n + 3];
        Arrays.fill(cum, 1);
        st = new StringTokenizer(br.readLine());
        while(k-- > 0) {
            int idx = Integer.parseInt(st.nextToken());
            sleep[idx] = true;
        }
        st = new StringTokenizer(br.readLine());
        while(q-- > 0) {
            int idx = Integer.parseInt(st.nextToken());
            if(sleep[idx]) continue;
            for(int i = idx; i < cum.length; i += idx) {
                if(sleep[i]) continue;
                cum[i] = 0;
            }
        }
        cum[2] = 0;
        for(int i = 4; i < cum.length; i++) {
            cum[i] += cum[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append((cum[e] - cum[s - 1]) + "\n");
        }
        System.out.println(sb.toString());
    }
}
