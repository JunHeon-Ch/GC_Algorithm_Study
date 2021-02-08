package algo_14499;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] dice = new int[6];
    static int[][] map;
    static int n, m, x, y;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            int test = Integer.parseInt(st.nextToken());
            simulation(test);
        }
        bw.close();
    }

    static void simulation(int t) throws IOException {
        int nx = x + dx[t];
        int ny = y + dy[t];
        if (nx >= n || nx < 0 || ny >= m || ny < 0) return;
        else {
            x = nx;
            y = ny;
        }

        int temp;
        switch (t) {
            case 1:
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 3:
                temp = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = temp;
                break;
            case 4:
                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = temp;
                break;
        }
        bw.write(dice[0] + "\n");
        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[5];
        } else {
            dice[5] = map[nx][ny];
            map[nx][ny] = 0;
        }

    }
}


