package algo_6603;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] valid;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] num = new int[n];
            valid = new boolean[n];
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            go(num, 0, n, 6, 0);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void go(int[] num, int index, int n, int m, int s) throws IOException {
        if (index == m) {
            for (int k : arr) {
                if (k != 0) bw.write(k + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = s; i < n; i++) {
            if (valid[i]) continue;
            arr[index] = num[i];
            valid[i] = true;
            go(num, index + 1, n, m, i + 1);
            valid[i] = false;
        }
    }
}



