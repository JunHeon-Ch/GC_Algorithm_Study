package PS_2021.BOJ.코딩테스트.문제.브루트포스.등차수열_변환_17088;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = -1;
        for(int d1 = -1; d1 <= 1; d1++) {
            for(int d2 = -1; d2 <= 1; d2++) {
                int res = 0;
                if(d1 != 0) res++;
                if(d2 != 0) res++;
                int diff = arr[1] + d2 - (arr[0] + d1);
                int cur = arr[0] + d1 + diff;
                int i;
                for(i = 2; i < N; i++) {
                    cur += diff;
                    if(arr[i] == cur) continue;
                    if(arr[i] + 1 == cur || arr[i] - 1 == cur) res++;
                    else break;
                }
                if(i == N) {
                    if(ans == -1 || ans > res) ans = res;
                }
            }
        }
        System.out.println(ans);
    }
}
