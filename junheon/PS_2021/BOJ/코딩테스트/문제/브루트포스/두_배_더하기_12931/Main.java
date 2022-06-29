package PS_2021.BOJ.코딩테스트.문제.브루트포스.두_배_더하기_12931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] b = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        while(true) {
            boolean allZero = true, isOdd = false;
            for(int i = 0; i < N; i++) {
                if(b[i] > 0) allZero = false;
                if(b[i] % 2 != 0) {
                    isOdd = true;
                    b[i]--;
                    ans++;
                }
            }
            if(allZero) break;
            if(!isOdd) {
                for(int i = 0; i < N; i++) {
                    b[i] /= 2;
                }
                ans++;
            }
        }
        System.out.println(ans);
    }
}
