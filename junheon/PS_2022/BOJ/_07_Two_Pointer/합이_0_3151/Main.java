package PS_2022.BOJ._07_Two_Pointer.합이_0_3151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/3151
 * 알고리즘: 투포인터
 * 시간복잡도: O(n^2), n=10,000(학생의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        long ans = 0;
        for (int k = 0; k < n; k++) {
            int l = k + 1, r = n - 1;
            while (l < r) {
                int sum = num[k] + num[l] + num[r];
                int lc = 1, rc = 1;
                if (sum == 0) {
                    if (num[l] == num[r]) {
                        ans += (r - l + 1) * (r - l) / 2;
                        break;
                    }
                    while (l + 1 < r && num[l] == num[l + 1]) {
                        lc++;
                        l++;
                    }
                    while (r - 1 > l && num[r] == num[r - 1]) {
                        rc++;
                        r--;
                    }
                    ans += lc * rc;
                }
                if (sum < 0) l++;
                else r--;
            }
        }
        System.out.println(ans);
    }
}
