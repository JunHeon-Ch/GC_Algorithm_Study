package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14499 {
    public static int n;
    public static int m;
    public static int x;
    public static int y;
    public static int[][] map;
    public static int[] dice = new int[7];
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] inst = new int[r];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<r; i++)
            inst[i] = Integer.parseInt(st.nextToken());

        for(int instruction : inst){
            int current_x = x + dx[instruction - 1];
            int current_y = y + dy[instruction - 1];

            if(current_x < 0 || current_y < 0 || current_x >= n || current_y >= m)
                continue;

            rollTheDice(instruction);
            if (map[current_x][current_y] == 0) {
                map[current_x][current_y] = dice[6];
            } else {
                dice[6] = map[current_x][current_y];
                map[current_x][current_y] = 0;
            }
            x = current_x;
            y = current_y;
            System.out.println(dice[1]);
        }

    }
    public static void rollTheDice(int d){

        int[] temp = dice.clone();
        // 6 밑면, 1 윗면
        // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
        if (d == 1) {
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        } else if (d == 2) {
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[4] = temp[1];
            dice[6] = temp[4];
        } else if (d == 3) {
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        } else {
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
    }
}
