package algo_1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2 {
    static int[] num;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        go(0, n, 0, s);
        bw.write(ans + "\n");
        bw.close();
    }

    static void go(int index, int n, int sum, int s) {
        if (index >= n) return;
        sum += num[index];
        if (sum == s) ans++;

        go(index + 1, n, sum, s);
        go(index + 1, n, sum - num[index], s);

    }
}

