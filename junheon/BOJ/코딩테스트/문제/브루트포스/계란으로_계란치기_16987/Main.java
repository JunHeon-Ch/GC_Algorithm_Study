package BOJ.코딩테스트.문제.브루트포스.계란으로_계란치기_16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] strength, weight;
    static int[] s, w;
    static int[] seq;
    static int ans = 0;

    public static int game() {
        s = Arrays.copyOf(strength, strength.length);
        w = Arrays.copyOf(weight, weight.length);
        int res = 0;
        for(int now = 0; now < N; now++) {
            int next = seq[now];
            if(s[now] <= 0 || s[next] <= 0) continue;
            s[now] -= w[next];
            s[next] -= w[now];
            if(s[now] <= 0) {
                res++;
            }
            if(s[next] <= 0) {
                res++;
            }
        }
        return res;
    }

    public static void solve(int index) {
        if (index == N) {
            int res = game();
            if(res != -1) ans = Math.max(ans, res);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (i != index) {
                seq[index] = i;
                solve(index + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strength = new int[N];
        weight = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            strength[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        seq = new int[N];
        solve(0);
        System.out.println(ans);
    }
}
