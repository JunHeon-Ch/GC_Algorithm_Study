package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1248 {
    public static int N;
    public static char[][] S;
    public static int[] ans;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new char[N][N];
        ans = new int[N];

        char[] arr = br.readLine().toCharArray();
        int idx = 0;
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                S[i][j] = arr[idx++];
            }
        }
        DFS(0);

    }
    public static void DFS(int depth){
        if(depth == N){
            for(int i=0; i<ans.length; i++)
                sb.append(ans[i]+" ");
            System.out.print(sb);
            System.exit(0);
        }
        for(int i=-10; i<11; i++){
            ans[depth] = i;
            if(isValid(depth)){
                DFS(depth+1);
            }
        }
    }
    public static boolean isValid(int depth){
        for (int i = 0; i <= depth; i++) {
            int sum = 0;
            for (int j = i; j <= depth; j++) {
                sum += ans[j];
                if (S[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
