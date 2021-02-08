package algo_15685;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[101][101];
    static int[] curve = new int[1024];
    // right, up, left, down
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int size = 0;
            curve[size++] = d;
            map[y][x] = 1;
            for (int j = 0; j < g; j++) {
                for (int k = size - 1; k >= 0; k--) {
                    curve[size++] = (curve[k] + 1) % 4;
                }
            }

            for (int j = 0; j < size; j++) {
                y += dy[curve[j]];
                x += dx[curve[j]];
                map[y][x] = 1;
            }

        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
                    ans++;
                }
            }
        }
        bw.write(ans + "\n");
        bw.close();
    }

}


