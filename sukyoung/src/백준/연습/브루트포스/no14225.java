package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14225 {
    public static int n, min;
    public static int[] s, ans;
    public static boolean[] visit = new boolean[2000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            s[i] = Integer.parseInt(st.nextToken());

        dfs(0,0);
        for(int i=1; i<visit.length; i++){
            if(!visit[i]){
                System.out.println(i);
                break;
            }
        }

    }

    public static void dfs(int depth, int sum){
        if(depth == n){
            visit[sum] = true;
            return;
        }
        dfs(depth+1, sum+s[depth]);
        dfs(depth+1, sum);
    }
}
