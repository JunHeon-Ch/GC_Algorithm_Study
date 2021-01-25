package algo_2529;

import java.io.*;

public class Main {
    static boolean[] valid = new boolean[10];
    static int[] num;
    static String[] s;
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    static int[] minArr;
    static int[] maxArr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        minArr = new int[n + 1];
        maxArr = new int[n + 1];
        s = br.readLine().split(" ");
        go(0, 10, n + 1);

        for (int i = 0; i < n + 1; i++) {
            System.out.print(maxArr[i]);
        }
        System.out.println();
        for (int i = 0; i < n + 1; i++) {
            System.out.print(minArr[i]);
        }
        System.out.println();

    }

    static void go(int index, int n, int m) {
        if (index == m) {
            int temp = 0;
            long result = 0;
            for (int i = m - 1; i >= 0; i--) {
                result += num[temp] * Math.pow(10, i);
                temp++;
            }
            if (result == 0) {
                return;
            }
            if (min > result) {
                min = result;
                for (int i = 0; i < m; i++) {
                    minArr[i] = num[i];
                }
            }
            if (max < result) {
                max = result;
                for (int i = 0; i < m; i++) {
                    maxArr[i] = num[i];
                }
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid[i]) continue;
            num[index] = i;
            valid[i] = true;
            if (index != 0) {
                if (s[index - 1].charAt(0) == '<') {
                    if (num[index - 1] >= num[index]) {
                        valid[i] = false;
                        num[index] = 0;
                        continue;
                    }
                } else {
                    if (num[index - 1] <= num[index]) {
                        valid[i] = false;
                        num[index] = 0;
                        continue;
                    }
                }

            }
            go(index + 1, n, m);
            valid[i] = false;
        }
    }


}
