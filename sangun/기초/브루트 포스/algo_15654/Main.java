package algo_15654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr = new int[10];
    static boolean[] valid = new boolean[10000];
    static int[] num;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        go(0, n, m);
        bw.flush();
        bw.close();


    }

    public static void go(int index, int n, int m) throws IOException {
        if (index == m) {
            for (int k : arr) {
                if (k != 0) bw.write(k + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid[num[i]]) continue;
            valid[num[i]] = true;
            arr[index] = num[i];
            go(index + 1, n, m);
            valid[num[i]] = false;

        }
    }
}
