package algo_14889;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bitmask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> first = new ArrayList<>();
            ArrayList<Integer> second = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    first.add(j);
                } else second.add(j);
            }
            if (first.size() != n / 2) continue;
            int t1 = 0;
            int t2 = 0;
            for (int l1 = 0; l1 < n / 2; l1++) {
                for (int l2 = 0; l2 < n / 2; l2++) {
                    if (l1 == l2) continue;
                    t1 += num[first.get(l1)][first.get(l2)];
                    t2 += num[second.get(l1)][second.get(l2)];
                }
            }
            int result = Math.abs(t1 - t2);
            ans = Math.min(result, ans);
        }


        bw.write(ans+"\n");
        bw.close();

    }
}
