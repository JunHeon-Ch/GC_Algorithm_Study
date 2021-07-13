// Bottom-up
// D(n) = N 위치까지 오는데 필요한 에너지의 최솟값 (BOJ 순서를 지킨다)
// 'B' = 0, 'O' = 1, 'J' = 2
// d[i] = min(d[i - k] + k^2) if (s[i - k] + 1) % 3 == s[i] (0 <= k < i < n)

package BOJ.코딩테스트.문제.DP.BOJ_거리_12026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_after {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String street = br.readLine();
        int[] d = new int[n];
        int[] s = new int[n];
        Arrays.fill(d, -1);
        for(int i = 0; i < n; i++) {
            int bn = 0;
            if(street.charAt(i) == 'B') bn = 0;
            else if(street.charAt(i) == 'O') bn = 1;
            else if(street.charAt(i) == 'J') bn = 2;
            s[i] = bn;
        }
        br.close();

        d[0] = 0;
        for(int i = 0; i < n; i++) {
            if(d[i] == -1) continue;
            int next = (s[i] + 1) % 3;
            for(int j = i + 1; j < n; j++) {
                if(s[j] == next) {
                    int k = (int) Math.pow(j - i, 2);
                    if(d[j] == -1) {
                        d[j] = d[i] + k;
                    } else {
                        d[j] = Math.min(d[j], d[i] + k);
                    }
                }
            }
        }
        System.out.println(d[n - 1]);
    }
}
