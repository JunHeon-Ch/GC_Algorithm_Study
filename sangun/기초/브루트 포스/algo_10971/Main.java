package algo_10971;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] num;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = new int[n][n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int result = Integer.MAX_VALUE;
        do {
//            for (int k : arr) {
//                if (k != 0) System.out.print(k + " ");
//            }
//            System.out.println();
            if (arr[0] != 0) break;
            boolean ok = true;
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (num[arr[i]][arr[i + 1]] == 0) ok = false;
                else sum += num[arr[i]][arr[i + 1]];
            }
            if (ok && num[arr[n - 1]][arr[0]] != 0) {
                sum += num[arr[n - 1]][arr[0]];
                result = Math.min(result, sum);
            }
        } while (permutation(arr));
        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    static boolean permutation(int[] num) {
        int i = num.length - 1;
        while (i > 0 && num[i - 1] >= num[i]) i--;
        if (i <= 0) return false;
        int j = num.length - 1;
        while (num[j] <= num[i - 1]) j--;
        swap(num, i - 1, j);
        j = num.length - 1;
        while (i < j) {
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
