package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class no16922 {
    public static int n;
    public static Set<Integer> ans = new HashSet<>();
    public static int[] num = {1, 5, 10, 50};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs(0, 0,0);
        System.out.println(ans.size());
    }
    public static void dfs(int depth, int start, int sum){
        if(depth == n){
            if(!ans.contains(sum)){
                ans.add(sum);
            }

            return;
        }

        for(int i=start; i<num.length; i++){
            dfs(depth + 1, i, sum + num[i]);
        }
    }
}
