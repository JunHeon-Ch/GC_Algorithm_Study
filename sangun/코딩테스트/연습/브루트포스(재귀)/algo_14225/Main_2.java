package algo_14225;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2 {
    static int[] num;
    static boolean[] ans = new boolean[2000001];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        go(0, 0);

        for (int i = 1; i < ans.length; i++) {
            if (!ans[i]) {
                bw.write(i + "\n");
                bw.close();
                break;
            }
        }

    }

    static void go(int selected, int sum) {
        if (selected >= n) {
            ans[sum] = true;
            return;
        }
        go(selected + 1, sum + num[selected]);
        go(selected + 1, sum);
    }
}
