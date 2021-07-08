package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1182 {
    public static int N;
    public static int M;
    public static int cnt;
    public static int[] arr;
    public static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        DFS(0,0);
        if(M==0){
            cnt--;
            System.out.println(cnt);
        }
        else
            System.out.println(cnt);
    }
    public static void DFS(int depth, int sum){
        if(depth == N){
            if(sum == M)
                cnt++;
            return;
        }

        DFS(depth +1, sum + arr[depth]);
        DFS(depth+1, sum);

    }
}
