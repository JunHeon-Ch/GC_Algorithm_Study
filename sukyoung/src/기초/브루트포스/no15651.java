package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no15651 {
    public static int N;
    public static int M;
    public static boolean visit[];
    public static int ans[];

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        ans = new int[M];

        DFS(0);
        System.out.print(sb);

    }
    public static void DFS(int depth){
        if(depth == M){
            for(int i=0; i< ans.length; i++)
                sb.append(ans[i]+" ");
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            if(visit[i] == false){
                ans[depth] = i+1;
                DFS(depth + 1);
            }
        }
    }
}
