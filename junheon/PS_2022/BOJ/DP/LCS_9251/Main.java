package PS_2022.BOJ.DP.LCS_9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/9251
 * 알고리즘: DP
 * 점화식
    s1[i] == s2[j] -> d[i][j] = d[i - 1][j - 1] + 1
    s1[i] != s2[j] -> d[i][j] = max(d[i - 1][j], d[i][j - 1])
    1 <= i <= s1.length, 1 <= j <= s2.length
 * 시간복잡도: O(n^2), n=1,000(문자열 길이)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int[][] d = new int[s1.length + 1][s2.length + 1];
        for(int i = 1; i <= s1.length; i++) {
            for(int j = 1; j <= s2.length; j++) {
                if(s1[i - 1] == s2[j - 1]) d[i][j] = d[i - 1][j - 1] + 1;
                else d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
            }
        }
        System.out.println(d[s1.length][s2.length]);
    }
}
