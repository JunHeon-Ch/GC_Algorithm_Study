package PS_2021.BOJ.코딩테스트.문제.브루트포스.로마_숫자_만들기_16922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_before {

    static boolean sum[];
    static int num[];
    static int ans = 0;

    public static void solve(int n, int index, int start) {
        if (n == index) {
            int res = 0;
            for(int i = 0; i < n; i++) {
                if(num[i] == 0) res += 1;
                else if(num[i] == 1) res += 5;
                else if(num[i] == 2) res += 10;
                else if(num[i] == 3) res += 50;
            }
            if(!sum[res]) {
                sum[res] = true;
                ans++;
            }
            return;
        }
        for (int i = start; i < 4; i++) {
            num[index] = i;
            solve(n, index + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sum = new boolean[n * 50 + 1];
        num = new int[n];
        solve(n, 0, 0);
        System.out.println(ans);
    }
}
