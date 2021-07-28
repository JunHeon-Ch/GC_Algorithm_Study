package BOJ.코딩테스트.문제.브루트포스.매직_스퀘어로_변경하기_16945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] original = new int[10];
    static int[] mixed = new int[10];
    static boolean[] visit = new boolean[10];
    static int ans = Integer.MAX_VALUE;

    public static boolean check() {
        int row1 = mixed[1] + mixed[2] + mixed[3];
        int row2 = mixed[4] + mixed[5] + mixed[6];
        if(row1 != row2) return false;
        int row3 = mixed[7] + mixed[8] + mixed[9];
        if(row2 != row3) return false;
        int col1 = mixed[1] + mixed[4] + mixed[7];
        if(row3 != col1) return false;
        int col2 = mixed[2] + mixed[5] + mixed[8];
        if(col1 != col2) return false;
        int col3 = mixed[3] + mixed[6] + mixed[9];
        if(col2 != col3) return false;
        int diag1 = mixed[1] + mixed[5] + mixed[9];
        if(col3 != diag1) return false;
        int diag2 = mixed[3] + mixed[5] + mixed[7];
        if(diag1 != diag2) return false;
        return true;
    }

    public static int calc() {
        int res = 0;
        for(int i = 1; i < 10; i++) {
            res += Math.abs(original[i] - mixed[i]);
        }
        return res;
    }

    public static void solve(int index) {
        if(index == 10) {
            if(check()) {
                ans = Math.min(ans, calc());
            }
            return;
        }
        for(int i = 1; i < 10; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            mixed[index] = i;
            solve(index + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 1, prev = 0;
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                original[k++] = Integer.parseInt(st.nextToken());
                if(!(i == 0 && j == 0) && prev != original[k - 1]) flag = false;
                prev = original[k - 1];
            }
        }
        if(!flag) solve(1);
        else ans = 0;
        System.out.println(ans);
    }
}
