package algo_10819;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        int ans = Integer.MIN_VALUE;
        do {
            ans = Math.max(calculate(num), ans);
        } while (permutation(num));
        bw.write(ans + "\n");
        bw.close();


    }

    static int calculate(int[] num) {
        int dif = 0;
        for (int i = 0; i < num.length - 1; i++) {
            dif += Math.abs(num[i] - num[i + 1]);
        }
        return dif;
    }

    static boolean permutation(int[] num) {
        int i = num.length - 1;
        while (i > 0 && num[i - 1] >= num[i]) i--;
        if (i <= 0) return false;
        int j = num.length - 1;
        while (num[j] <= num[i - 1]) j--;
        swap(num, i - 1, j);
        j = num.length - 1;
        while (j > i) {
            swap(num, i, j);
            i++;
            j--;
        }
        return true;

    }

    static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
