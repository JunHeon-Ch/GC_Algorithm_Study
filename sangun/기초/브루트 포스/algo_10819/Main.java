package algo_10819;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] valid;
    static int[] num;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        arr = new int[n];
        valid = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        go(0, n);
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    static void go(int index, int n) {
        if (index == n) {
            int temp = calculate(n);
            if (temp > max) max = temp;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid[i]) continue;
            arr[index] = num[i];
            valid[i] = true;
            go(index + 1, n);
            valid[i] = false;
        }
    }

    static int calculate(int n) {
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result += Math.abs(arr[i] - arr[i + 1]);
        }
        return result;
    }
}
