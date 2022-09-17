package PS_2022.BOJ._08_Implementation.홀수_홀릭_호석_20164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/20164
 * 알고리즘: 구현
 */

public class Main {

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        solve(num, 0);
        System.out.println(min + " " + max);
    }

    static void solve(String num, int res) {
        if(num.length() == 1) {
            int n = Integer.parseInt(num);
            if(n % 2 == 1) res++;
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }
        if(num.length() == 2) {
            int n1 = Integer.parseInt(num.substring(0, 1));
            int n2 = Integer.parseInt(num.substring(1));
            if(n1 % 2 == 1) res++;
            if(n2 % 2 == 1) res++;
            solve(Integer.toString(n1 + n2), res);
        } else {
            int cnt = 0;
            for(char c : num.toCharArray()) {
                int n = c - '0';
                if(n % 2 == 1) cnt++;
            }
            for(int i = 1; i < num.length(); i++) {
                for(int j = i + 1; j < num.length(); j++) {
                    if(i == j) continue;
                    int n1 = Integer.parseInt(num.substring(0, i));
                    int n2 = Integer.parseInt(num.substring(i, j));
                    int n3 = Integer.parseInt(num.substring(j));
                    solve(Integer.toString(n1 + n2 + n3), res + cnt);
                }
            }
        }
    }

}
