package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 숫자판점프 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static HashSet<String> ans = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                go(map,i,j,"");
            }
        }

        System.out.println(ans.size());

    }

    static void go(int[][] map, int x, int y, String str) {
        if (str.length() == 6) {
            ans.add(str);
            return;
        }

        str += map[x][y];
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 5 || y + dy[i] >= 5 || x + dx[i] < 0 || y + dy[i] < 0) continue;
            go(map, x + dx[i], y + dy[i], str);
        }

    }

}
