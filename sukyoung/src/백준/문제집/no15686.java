package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class location{
    int x;
    int y;
    location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class no15686 {
    public static int min = Integer.MAX_VALUE;
    public static ArrayList<location> chicken_list, house_list;
    public static boolean[] visit;
    public static int[][] city;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        chicken_list = new ArrayList<>();
        house_list = new ArrayList<>();
        city = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                city[i][j] = Integer.parseInt(st.nextToken());

                if(city[i][j] == 2)
                    chicken_list.add(new location(i,j));
                else if(city[i][j] == 1)
                    house_list.add(new location(i, j));
            }
        }

        visit = new boolean[chicken_list.size()];
        dfs(0, 0, m);

        System.out.println(min);
    }
    public static void dfs(int depth, int start, int m){
        if(depth == m){
            min = Math.min(min, calc());
            return;
        }

        for(int i=start; i<chicken_list.size(); i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(depth+1, i, m);
                visit[i] = false;
            }
        }
    }
    public static int calc(){
        int sum = 0;

        for(int i=0; i<house_list.size(); i++){
            int distance = Integer.MAX_VALUE;

            for(int j=0; j<chicken_list.size(); j++){
                if(visit[j]){
                    int temp = Math.abs(chicken_list.get(j).x - house_list.get(i).x) + Math.abs(chicken_list.get(j).y - house_list.get(i).y);
                    distance = Math.min(temp, distance);
                }
            }
            sum += distance;
        }

        return sum;
    }
}
