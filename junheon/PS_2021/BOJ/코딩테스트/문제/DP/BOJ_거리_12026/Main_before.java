// Bottom-up
// D(n) = N 위치까지 오는데 필요한 에너지의 최솟값 (PS_2021.BOJ 순서를 지킨다)
// 'B' = 0, 'O' = 1, 'J' = 2
// d[i][0] = min(d[i - k][2] + k^2) (0 <= k < i < n)
// d[i][1] = min(d[i - k][0] + k^2) (0 <= k < i < n)
// d[i][2] = min(d[i - k][1] + k^2) (0 <= k < i < n)

package PS_2021.BOJ.코딩테스트.문제.DP.BOJ_거리_12026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_before {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String street = br.readLine();
        int[][] d = new int[n][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                d[i][j] = -1;
            }
        }
        br.close();

        d[0][0] = 0;
        for(int i = 1; i < n; i++) {
            char block = street.charAt(i);
            char preBlock = 0;
            int bn = 0, pbn = 0;
            if(block == 'B') {
                preBlock = 'J';
                bn = 0; pbn = 2;
            } else if(block == 'O') {
                preBlock = 'B';
                bn = 1; pbn = 0;
            } else if(block == 'J') {
                preBlock = 'O';
                bn = 2; pbn = 1;
            }
            for(int j = i - 1; j >= 0; j--) {
                if(d[j][pbn] != -1 && street.charAt(j) == preBlock) {
                    int k = (int)Math.pow(i - j, 2);
                    if(d[i][bn] == -1) {
                        d[i][bn] = d[j][pbn] + k;
                    } else {
                        d[i][bn] = Math.min(d[i][bn], d[j][pbn] + k);
                    }
                }
            }
        }
        int ans = -1;
        for(int i = 0; i < 3; i++) {
            if(d[n - 1][i] != -1) ans = d[n - 1][i];
        }
        System.out.println(ans);
    }
}
