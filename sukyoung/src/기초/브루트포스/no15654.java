package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no15654 {

    public static int N;
    public static int M;
    public static boolean visit[];
    public static int num[];
    public static int ans[];

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);
        visit = new boolean[N];
        ans = new int[M];

        DFS(0);
        System.out.print(sb);
    }
    public static void DFS(int depth){
        if(depth == M){
            for(int i=0; i<ans.length; i++)
                sb.append(ans[i] +" ");
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            if(visit[i] == false){
                visit[i] = true;
                ans[depth] = num[i];
                DFS(depth+1);
                visit[i] = false;
            }
        }
    }
}
