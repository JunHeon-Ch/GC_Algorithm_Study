package BOJ.코딩테스트.문제.브루트포스.차량_번호판1_16968;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_before {

    static char[] input;

    public static int solve(int index, int prev, char prevNum) {
        if(index == input.length) return 1;
        char flag = input[index];
        int ans = 0;
        if(flag == 'c') {
            for(int i = 0; i < 26; i++) {
                if(prevNum == flag && prev == i) continue;
                ans += solve(index + 1, i, flag);
            }
        } else if(flag == 'd') {
            for(int i = 0; i < 10; i++) {
                if(prevNum == flag && prev == i) continue;
                ans += solve(index + 1, i, flag);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        System.out.println(solve(0, -1, ' '));
    }
}
