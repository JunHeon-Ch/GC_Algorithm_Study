package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class no2667 {
    public static int n;
    public static int[][] house;
    public static boolean[][] visit;
    public static int sum;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        house = new int[n][n];
        visit = new boolean[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++)
                house[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
        }

        ArrayList<Integer> sumArr = new ArrayList<>();
        sum = 0;
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dfs(i,j) == true){
                    sumArr.add(sum++);
                    cnt++;
                    sum = 0;
                }
            }
        }
        Collections.sort(sumArr);
        System.out.println(cnt);
        for(int i: sumArr)
            System.out.println(i);
    }
    public static boolean dfs(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >=n)
            return false;

        if(!visit[x][y] && house[x][y] != 0){
            visit[x][y] = true;
            sum++;
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x,y+1);

            return true;
        }
        return false;
    }
}
