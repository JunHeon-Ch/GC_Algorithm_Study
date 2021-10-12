package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1018 {
    public static int n, m;
    public static int min = 64;
    public static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        for(int i=0; i<n; i++){
            map[i] = br.readLine().split("");
        }

        int N_row = n - 7;
        int M_col = m - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                coloring(i, j);
            }
        }
        System.out.print(min);
    }
    public static void coloring(int x, int y){
        int cnt = 0;
        String color = map[x][y];

        for(int i = x; i < x + 8; i++){
            for(int j= y; j < y + 8; j++){
                if(!color.equals(map[i][j]))
                    cnt++;

                if(color.equals("B"))
                    color = "W";
                else
                    color = "B";
            }
            if(color.equals("B"))
                color = "W";
            else
                color = "B";
        }

        cnt = Math.min(cnt, 64-cnt);
        min = Math.min(min, cnt);
    }
}
