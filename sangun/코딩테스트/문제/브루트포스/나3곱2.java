package 브루트포스;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 나3곱2 {
    static HashSet<Long> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = Long.parseLong(st.nextToken());
            set.add(b[i]);
        }
        for (int i = 0; i < n; i++) {
            ArrayList<Long> ans = new ArrayList<>();
            ans.add(b[i]);
            set.remove(b[i]);
            dfs(ans, 1, b[i]);
            ans.remove(0);
            set.add(b[i]);
        }

    }

    static void dfs(ArrayList<Long> ans, int index, long value) {

        if (set.isEmpty()) {
            for (long k : ans) {
                System.out.print(k + " ");
            }
            System.out.println();
            System.exit(0);
            return;
        }

        if (set.contains(value * 2)) {
            ans.add(value * 2);
            set.remove(value * 2);
            dfs(ans, index + 1, value * 2);
            ans.remove(index);
            set.add(value * 2);

        }
        if (value % 3 == 0) {
            if (set.contains(value / 3)) {
                ans.add(value / 3);
                set.remove(value / 3);
                dfs(ans, index + 1, value / 3);
                ans.remove(index);
                set.add(value / 3);
            }
        }


    }

}
