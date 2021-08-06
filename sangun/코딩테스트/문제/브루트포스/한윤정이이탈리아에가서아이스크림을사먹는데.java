package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 한윤정이이탈리아에가서아이스크림을사먹는데 {
    static int n;
    static int ans = 0;
    static HashSet<Integer>[] bad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        bad = new HashSet[n + 1];
        for (int i = 0; i < n + 1; i++) {
            bad[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bad[a].add(b);
            bad[b].add(a);
        }

        go(1, 0, new int[3]);
        System.out.println(ans);
    }

    static void go(int index, int selected, int[] result) {
        if (selected == 3) {
            if (valid(result)) {
                ans++;
            }
            return;
        }
        if (index > n) {
            return;
        }

        result[selected] = index;
        go(index + 1, selected + 1, result);
        go(index + 1, selected, result);
    }

    static boolean valid(int[] result) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (bad[result[i]].contains(result[j])) return false;
            }
        }
        return true;
    }


}
