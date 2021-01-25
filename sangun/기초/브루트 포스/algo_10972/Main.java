package algo_10972;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        if (permutation(n)) {
            for (int k : num) {
                if (k != 0) bw.write(k + " ");
            }
        } else bw.write(-1 + "");

        bw.flush();
        bw.close();

    }

    static boolean permutation(int n) {
        int i = n - 1;
        while (i > 0 && num[i - 1] >= num[i]) i--;
        if (i <= 0) return false;
        int j = n - 1;
        while (num[j] <= num[i - 1]) j--;
        swap(j, i - 1);
        j = n - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;

    }

    static void swap(int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

}
