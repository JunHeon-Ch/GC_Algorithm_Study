package PS_2022.BOJ.Back_Tracking.연산자_끼워넣기_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/14888
 * 알고리즘: 완전탐색
 * 시간복잡도: O(4^n), n=10(연산자의 수)
 */

public class Main {

    static int n;
    static int[] num;
    static char[] op;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        op = new char[n - 1];
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int product = Integer.parseInt(st.nextToken());
        int division = Integer.parseInt(st.nextToken());
        solve(0, plus, minus, product, division);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int index, int plus, int minus, int product, int division) {
        if(index == n - 1) {
                int res = num[0];
            for(int i = 0; i < n - 1; i++) {
                if(op[i] == '+') res += num[i + 1];
                else if(op[i] == '-') res -= num[i + 1];
                else if(op[i] == '*') res *= num[i + 1];
                else if(op[i] == '/') {
                    int val = Math.abs(res) / num[i + 1];
                    if(res < 0) res = -val;
                    else res = val;
                }
            }
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }
        if(plus > 0) {
            op[index] = '+';
            solve(index + 1, plus - 1, minus, product, division);
        }
        if(minus > 0) {
            op[index] = '-';
            solve(index + 1, plus, minus - 1, product, division);
        }
        if(product > 0) {
            op[index] = '*';
            solve(index + 1, plus, minus, product - 1, division);
        }
        if(division > 0) {
            op[index] = '/';
            solve(index + 1, plus, minus, product, division - 1);
        }
    }
}
