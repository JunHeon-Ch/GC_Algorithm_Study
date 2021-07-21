package BOJ.코딩테스트.문제.브루트포스.야구_17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] score;
    static int[] lineup;
    static boolean[] visit;
    static int ans = 0;

    public static int calc() {
        int res = 0, cur = 0;
        for (int i = 0; i < N; i++) {
            int out = 0;
            boolean base1 = false, base2 = false, base3 = false;
            while (out < 3) {
                int player = score[i][lineup[cur]];
                if (player == 0) {
                    out++;
                } else if (player == 1) {
                    if (base3) {
                        res++;
                        base3 = false;
                    }
                    if (base2) {
                        base3 = true;
                        base2 = false;
                    }
                    if (base1) {
                        base2 = true;
                        base1 = false;
                    }
                    base1 = true;
                } else if (player == 2) {
                    if (base3) {
                        res++;
                        base3 = false;
                    }
                    if (base2) {
                        res++;
                        base2 = false;
                    }
                    if (base1) {
                        base3 = true;
                        base1 = false;
                    }
                    base2 = true;
                } else if (player == 3) {
                    if (base3) {
                        res++;
                        base3 = false;
                    }
                    if (base2) {
                        res++;
                        base2 = false;
                    }
                    if (base1) {
                        res++;
                        base1 = false;
                    }
                    base3 = true;
                } else if (player == 4) {
                    int point = 1;
                    if (base3) {
                        point++;
                        base3 = false;
                    }
                    if (base2) {
                        point++;
                        base2 = false;
                    }
                    if (base1) {
                        point++;
                        base1 = false;
                    }
                    res += point;
                }
                cur = (cur + 1) % 9;
            }
        }
        return res;
    }

    public static void solve(int index) {
        if (index == 3) {
            solve(index + 1);
        }
        if (index == 9) {
            int res = calc();
            ans = Math.max(ans, res);
            return;
        }
        if(index != 3) {
            for (int i = 0; i < 9; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    lineup[index] = i;
                    solve(index + 1);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        lineup = new int[9];
        visit = new boolean[9];
        Arrays.fill(lineup, -1);
        lineup[3] = 0;
        visit[0] = true;
        solve(0);
        System.out.println(ans);
    }
}
