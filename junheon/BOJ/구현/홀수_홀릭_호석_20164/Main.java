package BOJ.구현.홀수_홀릭_호석_20164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/20164
 * 알고리즘: 구현
 */

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        split(num, 0);
        System.out.println(min + " " + max);
    }

    public static void split(String num, int res) {
        res += countOdd(num);

        if (num.length() == 1) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }
        if (num.length() == 2) {
            split(((num.charAt(0) - '0') + (num.charAt(1) - '0')) + "", res);
            return;
        }
        for (int i = 1; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                split(Integer.parseInt(num.substring(0, i)) + Integer.parseInt(num.substring(i, j)) +
                        Integer.parseInt(num.substring(j)) + "", res);
            }
        }
    }

    public static int countOdd(String num) {
        int res = 0;
        for (char c : num.toCharArray()) {
            if ((c - '0') % 2 == 1) res++;
        }
        return res;
    }
}
