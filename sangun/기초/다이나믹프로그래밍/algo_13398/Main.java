package algo_13398;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.max;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp1[0] = num[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = max(dp1[i - 1] + num[i], num[i]);
        }
        dp2[n - 1] = num[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = max(dp2[i + 1] + num[i], num[i]);
        }

        int max = dp1[0];
        for (int k : dp1) {
            if (k > max) {
                max = k;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (max < dp1[i - 1] + dp2[i + 1])
                max = dp1[i - 1] + dp2[i + 1];

        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();

    }
}
