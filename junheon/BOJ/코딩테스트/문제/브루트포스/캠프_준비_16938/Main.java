package BOJ.코딩테스트.문제.브루트포스.캠프_준비_16938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R, X;
    static int[] arr;
    static int ans = 0;

    public static void solve(int index, int selected, int count, int min, int max, int sum) {
        if(selected == count) {
            if(max - min >= X && sum >= L && sum <= R) ans++;
            return;
        }
        if(index >= N) return;
        if(min == -1)
            solve(index + 1, selected + 1, count, arr[index], arr[index], sum + arr[index]);
        else
            solve(index + 1, selected + 1, count, min, arr[index], sum + arr[index]);
        solve(index + 1, selected, count, min, max, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 2; i <= N; i++) {
            solve(0, 0, i, -1, -1, 0);
        }
        System.out.println(ans);
    }
}
