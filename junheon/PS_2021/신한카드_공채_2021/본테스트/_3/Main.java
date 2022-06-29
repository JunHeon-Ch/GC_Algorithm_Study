package PS_2021.신한카드_공채_2021.본테스트._3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] ordered = Arrays.copyOf(num, num.length);
        Arrays.sort(ordered);

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(num[i] != ordered[i]) ans++;
        }
        System.out.println(ans);
        br.close();
    }
}