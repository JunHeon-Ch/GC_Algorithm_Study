package algo_1248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] ans;
    static int[][] s;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        ans = new int[n];

        char[] str = br.readLine().toCharArray();
        int limit = n * (n + 1) / 2;
        int r = 0, c = 0;
        int strIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (str[strIdx] == '-') s[i][j] = -1;
                else if (str[strIdx] == '0') s[i][j] = 0;
                else if (str[strIdx] == '+') s[i][j] = 1;
                strIdx++;
            }

        }
        if (go(0)) {
            for (int k : ans) {
                System.out.print(k + " ");
            }
        }


    }

    static boolean go(int index) {
        if (index == n) return true;
        if (s[index][index] == 0) {
            ans[index] = 0;
            return check(index) && go(index + 1);
        }
        for (int i = 1; i <= 10; i++) {
            ans[index] = s[index][index] * i;
            if (check(index) && go(index + 1)) return true;
        }
        return false;
    }

    static boolean check(int index) {
        int sum = 0;
        for (int i = index; i >= 0; i--) {
            sum += ans[i];
            if (s[i][index] == 0) {
                if (sum != 0) return false;
            } else if (s[i][index] < 0) {
                if (sum >= 0) return false;
            } else if (s[i][index] > 0) {
                if (sum <= 0) return false;
            }
        }
        return true;
    }
}

