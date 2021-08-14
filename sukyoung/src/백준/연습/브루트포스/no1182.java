package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1182 {
    public static int n,s,cnt;
    public static int[] arr, ans;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cnt = 0;
        dfs(0,0);

        //합이 0이면 공집합도 포함되므로 빼주고 출력해줘야 함
        if(s == 0)
            cnt--;
        System.out.print(cnt);

    }
    public static void dfs(int depth, int sum){
        if(depth == n){
            if(sum == s){
                cnt++;
            }
            return;
        }
        dfs(depth+1, sum + arr[depth]);
        dfs(depth+1, sum);
    }
}
