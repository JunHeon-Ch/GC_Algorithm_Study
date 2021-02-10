package algo_14225;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int[] num;
    static boolean[] ans = new boolean[2000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        go(0, 0, n, n, 0);

        for (int i = 0; i <= 2000000; i++) {
            if (!ans[i]){
                bw.write(i + "\n");
                bw.close();
                break;
            }
        }


    }

    static void go(int index, int selected, int n, int m, int sum) {
        if (selected == m) {
            ans[sum] = true;
            return;
        }
        if (index >= n) {
            ans[sum] = true;
            return;
        }
        go(index + 1, selected + 1, n, m, sum + num[index]);
        go(index + 1, selected, n, m, sum);


    }
}

