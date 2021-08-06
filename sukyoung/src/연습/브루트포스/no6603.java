package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no6603 {
    public static int k;
    public static int[] num;
    public static boolean[] visit;
    public static int[] ans = new int[6];
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            num = new int[k];
            visit = new boolean[k];
            if(k == 0)
                break;
            else{
                for(int i=0; i<k; i++){
                    num[i] = Integer.parseInt(st.nextToken());
                }
                dfs(0,0);
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
    public static void dfs(int start, int depth){
        if(depth == 6){
            for(int i=0; i< ans.length; i++)
                sb.append(ans[i]+" ");
            sb.append('\n');

            return;
        }
        for(int i=start; i<k; i++){
            if(visit[i])
                continue;

            visit[i] = true;
            ans[depth] = num[i];
            dfs(i+1, depth+1);
            visit[i] = false;
        }
    }
}
