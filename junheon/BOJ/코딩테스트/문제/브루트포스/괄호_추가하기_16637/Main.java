package BOJ.코딩테스트.문제.브루트포스.괄호_추가하기_16637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static List<Integer> num = new ArrayList<>();
    static List<Character> op = new ArrayList<>();
    static int ans = Integer.MIN_VALUE;

    public static int calc(int x, int y, char o) {
        if(o == '+') return x + y;
        if(o == '-') return x - y;
        return x * y;
    }

    public static void solve(int idx, int sum) {
        if(idx == op.size()) {
            ans = Math.max(ans, sum);
            return;
        }
        solve(idx + 1, calc(sum, num.get(idx + 1), op.get(idx)));
        if(idx + 1 < op.size())
            solve(idx + 2, calc(sum, calc(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1)), op.get(idx)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(char c : br.readLine().toCharArray()) {
            if(c >= '0' && c <= '9') num.add(c - '0');
            else op.add(c);
        }
        solve(0, num.get(0));
        System.out.println(ans);
    }
}
