package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 괄호추가하기2 {
    static int n;
    static long ans = Long.MIN_VALUE;
    static char[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        str = br.readLine().toCharArray();

        if (n==1){
            System.out.println(str[0]);
            System.exit(0);
        }

        go(1, 0, new int[n / 2], false);
        System.out.println(ans);
    }

    static void go(int index, int selected, int[] seq, boolean check) {
        if (index >= n) {
            ans = Math.max(ans, sol(seq));
            return;
        }

        if (!check) {
            seq[selected] = index;
            go(index + 2, selected + 1, seq, true);
        }
        seq[selected] = 0;
        go(index + 2, selected, seq, false);
    }


    static long sol(int[] seq) {
        ArrayList<String> s = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (seq[k] != 0 && seq[k] - 1 == i) {
                s.add(String.valueOf(cal(str[seq[k]], str[seq[k] - 1] - '0', str[seq[k] + 1] - '0')));
                k++;
                i += 2;
            } else {
                s.add(String.valueOf(str[i]));
            }
        }

        for (int i = 0; i < s.size(); i++) {
            if (i % 2 == 1 && s.get(i).equals("*")) {
                long tmp = Long.parseLong(s.get(i - 1)) * Long.parseLong(s.get(i + 1));
                s.add(i - 1, String.valueOf(tmp));
                s.remove(i);
                s.remove(i);
                s.remove(i);
                i = i - 1;
            }
        }
        while (s.size() != 1) {
            long a = Long.parseLong(s.remove(0));
            String op = s.remove(0);
            long b = Long.parseLong(s.remove(0));
            s.add(0, String.valueOf(cal(op.charAt(0), a, b)));
        }
        return Long.parseLong(s.remove(0));

    }

    static long cal(char op, long a, long b) {
        if (op == '*') return a * b;
        else if (op == '-') return a - b;
        else return a + b;
    }

}
