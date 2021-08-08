package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no14888 {
    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int[] A, inst_cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        inst_cnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            inst_cnt[i] = Integer.parseInt(st.nextToken());

        dfs(A[0],1);

        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int num, int idx){
        if (idx == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (inst_cnt[i] > 0) {

                // 해당 연산자를 1 감소시킨다.
                inst_cnt[i]--;

                switch (i) {

                    case 0:	dfs(num + A[idx], idx + 1);	break;
                    case 1:	dfs(num - A[idx], idx + 1);	break;
                    case 2:	dfs(num * A[idx], idx + 1);	break;
                    case 3:	dfs(num / A[idx], idx + 1);	break;

                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                inst_cnt[i]++;
            }
        }

    }
}
