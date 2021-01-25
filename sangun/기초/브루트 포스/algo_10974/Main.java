package algo_10974;

import java.io.*;

public class Main {
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
            bw.write(num[i] + " ");
        }
        bw.write("\n");
        while (permutation(n)) {
            for (int k : num) {
                bw.write(k + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    static boolean permutation(int n) {
        int i = n - 1;
        while (i > 0 && num[i - 1] >= num[i]) i--;
        if (i <= 0) return false;
        int j = n - 1;
        while (num[j] <= num[i - 1]) j--;
        swap(i - 1, j);
        j = n - 1;
        while (i < j) {
            swap(i, j);
            j--;
            i++;
        }
        return true;
    }

    static void swap(int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
