package algo_14002;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[1001];
    static int[] dp = new int[1001];
    static int[] v = new int[1001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            int temp = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    temp = j;
                }
            }
            v[i] = temp;

        }

        int max = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        v[1] = -1;
        bw.write(max + "\n");
        go(index);

        bw.flush();
        bw.close();
    }

    public static void go(int p) throws IOException {
        if (p == -1) return;
        go(v[p]);
        bw.write(arr[p] + " ");
    }

}

