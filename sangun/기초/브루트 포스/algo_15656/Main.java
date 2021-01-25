package algo_15656;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[8];
    static int[] num;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        go(0, n, m);

        bw.flush();
        bw.close();

    }

    static void go(int index, int n, int m) throws IOException {
        if (index == m) {
            for (int k : arr) {
                if (k != 0) bw.write(k + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[index] = num[i];
            go(index + 1, n, m);
        }

    }
}
