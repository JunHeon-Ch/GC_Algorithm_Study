package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no6603 {
    public static int N;
    public static int[] arr;
    public static int[] ans = new int[6];
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String temp[] = br.readLine().split(" ");
            N = Integer.parseInt(temp[0]);

            if(N == 0)
                break;

            arr = new int[N];
            visit = new boolean[N];
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(temp[i+1]);

            perm(0,0);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    public static void perm(int start, int depth){
        if(depth == 6){
            for(int i=0; i<ans.length; i++)
                sb.append(ans[i]+" ");
            sb.append('\n');
            return;
        }
        for(int i = start ; i < N; i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            ans[depth] = arr[i];
            perm(i+1, depth + 1);
            visit[i] = false;
        }
    }
}
