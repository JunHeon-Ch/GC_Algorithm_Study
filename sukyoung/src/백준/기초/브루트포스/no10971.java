package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no10971 {
    public static int city;
    public static int[][] cost;
    public static boolean[] visit;
    public static int[] ans;
    public static int min_cost;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(br.readLine());
        cost = new int[city][city];
        visit = new boolean[city];
        ans = new int[city];

        for(int i=0; i<city; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<city; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min_cost = Integer.MAX_VALUE;
        perm(0);
        System.out.print(min_cost);
    }
    public static void perm(int depth){
        if(depth == city){
            min_cost = Math.min(calc_cost(),min_cost);
            return;
        }

        for(int i=0; i<city; i++){
            if(visit[i] == false){
                visit[i] = true;
                ans[depth] = i;
                perm(depth+1);
                visit[i] = false;
            }
        }
    }
    public static int calc_cost(){

        int sum = 0;
        for(int i=0; i<ans.length; i++){
            if(i == ans.length -1)
                if(cost[ans[i]][ans[0]] == 0)
                    return Integer.MAX_VALUE;
                else {
                    sum += cost[ans[i]][ans[0]];
                }
            else {
                if(cost[ans[i]][ans[i+1]] == 0)
                    return Integer.MAX_VALUE;
                else
                    sum += cost[ans[i]][ans[i+1]];
            }
        }
        return sum;
    }
}
