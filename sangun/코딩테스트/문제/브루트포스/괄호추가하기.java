package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 괄호추가하기 {
    static char[] s;
    static int n;
    static int[] op;
    static long ans = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        op = new int[n / 2];
        int t = 1;
        for (int i = 0; i < n / 2; i++) {
            op[i] = t;
            t += 2;
        }
        s = br.readLine().toCharArray();
        go(0, 0, new ArrayList<>(), false);
        System.out.println(ans);

    }

    static void go(int index, int selected, ArrayList<Integer> seq, boolean check) {
        if (index == n / 2) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(seq);
            ans = Math.max(ans, result(tmp));
            return;
        }

        if (!check) {
            seq.add(op[index]);
            go(index + 1, selected + 1, seq, true);
            seq.remove(selected);
        }
        go(index + 1, selected, seq, false);
    }

    static long cal(char op, long a, long b) {
        if (op == '+') return a + b;
        if (op == '*') return a * b;
        return a - b;
    }

    static long result(ArrayList<Integer> seq) {
        long total = 0;
        int k = -1;
        ArrayList<String> str = new ArrayList<>();
        if (!seq.isEmpty()) {
            k = seq.remove(0);
        }
        for (int i = 0; i < n; i++) {
            if (k - 1 == i) {
                str.add(String.valueOf(cal(s[k], s[k - 1] - '0', s[k + 1] - '0')));
                if (!seq.isEmpty()) {
                    k = seq.remove(0);
                }
                i += 2;
            } else {
                str.add(String.valueOf(s[i]));
            }
        }

        while (str.size() != 1) {
            long a = Long.parseLong(str.remove(0));
            String op = str.remove(0);
            long b = Long.parseLong(str.remove(0));
            str.add(0, String.valueOf(cal(op.charAt(0), a, b)));
        }
        return Long.parseLong(str.remove(0));

    }
}
