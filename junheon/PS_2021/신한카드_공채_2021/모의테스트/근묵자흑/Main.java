package PS_2021.신한카드_공채_2021.모의테스트.근묵자흑;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if(min > num[i]) {
                minIdx = i;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            int res = i == 0 || i == k ? 0 : 1;
            int idx = minIdx - i;
            while(idx > 0) {
                idx = idx - k + 1;
                res++;
            }
            idx = minIdx + k - i - 1;
            while(idx < n - 1) {
                idx = idx + k - 1;
                res++;
            }
            ans = Math.min(ans, res);
        }
        System.out.println(ans);
    }
}