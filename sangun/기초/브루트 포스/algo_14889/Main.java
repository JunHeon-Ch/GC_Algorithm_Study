package algo_14889;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] valid = new boolean[22];
    static int[][] s;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        s = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = combination(n, n / 2) / 2;


        go(0, n, n / 2, 1);
        System.out.println(min);


    }

    static void go(int index, int n, int m, int s) {
        if (cnt == 0) return;
        if (index == m) {
            cnt--;
            int k = calculate(arr, n);
            min = Math.min(min, k);
            return;
        }

        for (int i = s; i <= n; i++) {
            if (valid[i]) continue;
            arr.add(i);
            valid[i] = true;
            go(index + 1, n, m, i + 1);
            arr.remove(index);
            valid[i] = false;
        }
    }

    static int calculate(ArrayList<Integer> a, int n) {
        ArrayList<Integer> t1 = new ArrayList<>();
        ArrayList<Integer> t2 = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (a.contains(i)) t1.add(i);
            else t2.add(i);
        }
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < t1.size(); i++) {
            for (int j = 0; j < t1.size(); j++) {
                if (j != i) result1 += s[t1.get(i)][t1.get(j)];
            }
        }
        for (int i = 0; i < t2.size(); i++) {
            for (int j = 0; j < t2.size(); j++) {
                if (j != i) result2 += s[t2.get(i)][t2.get(j)];
            }
        }
        return Math.abs(result1 - result2);
    }

    public static int combination(int n, int r) {
        if (n == r || r == 0)
            return 1;
        else
            return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
