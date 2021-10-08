package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no6603 {
    public static boolean[] visit;
    public static int[] ans;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0)
                break;

            int[] num = new int[k];
            for(int i=0; i<k; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[k];
            ans = new int[6];
            dfs(0, 0, num);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    public static void dfs(int depth, int start, int[] num){
        if(depth == 6){
            for(int a : ans)
                sb.append(a+" ");
            sb.append('\n');
            return;
        }
        for(int i=start; i<num.length; i++){
            if(!visit[i]){
                visit[i] = true;
                ans[depth] = num[i];
                dfs(depth + 1, i, num);
                visit[i] = false;
            }
        }
    }
}
