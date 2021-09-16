package 시험;

import java.util.Arrays;
import java.util.HashSet;

public class 문제4 {
    static int[] count;
    static int ans;
    static int[] answer;
    static HashSet<String> set;

    public static void main(String[] args) {
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int n = 1;
        set = new HashSet<>();
        answer = new int[11];
        count = new int[11];
        ans = Integer.MIN_VALUE;
        int v = 10;
        for (int i = 0; i < 11; i++) {
            count[i] = v--;
        }

        dfs(n, 0, new int[11], info);

        System.out.println(Arrays.toString(answer));
        System.out.println(ans);

        if (ans < 0) {
            int[] result = new int[1];
            result[0] = -1;
        }
    }

    static void dfs(int n, int m, int[] cnt, int[] info) {
        if (m == n) {

            int value = dif(cnt, info);
            if (value >= ans) {
                ans = value;
                for (int i = 0; i < cnt.length; i++) {
                    answer[i] = cnt[i];
                }
            }
            return;
        }
        set.add(Arrays.toString(cnt));
        for (int i = 0; i <= 10; i++) {
            if (cnt[i] > info[i]) continue;
            cnt[i]++;
            if (!set.contains(Arrays.toString(cnt))) {
                dfs(n, m + 1, cnt, info);
            }
            cnt[i]--;
        }

    }

    static int dif(int[] lion, int[] apeach) {
        int l = 0;
        int a = 0;
        for (int i = 0; i < lion.length; i++) {
            if (lion[i] > apeach[i]) {
                l += count[i];
            } else if (apeach[i] != 0) {
                a += count[i];
            }
        }
        return l - a;
    }
}
