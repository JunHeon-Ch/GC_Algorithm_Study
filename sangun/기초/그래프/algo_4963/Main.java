package algo_4963;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = 0;
            for (int x = 0; x < h; x++) {
                for (int y = 0; y < w; y++) {
                    dfs(map, x, y);
                    if (cnt > 0) ans++;
                    cnt = 0;
                }
            }
            bw.write(ans + "\n");


        }
        bw.close();
    }

    static void dfs(int[][] map, int x, int y) {
        if (map[x][y] == 0) return;
        cnt++;
        map[x][y] = 0;

        // 아래
        if (x + 1 < h) {
            dfs(map, x + 1, y);
            // 아래 오른쪽
            if (y + 1 < w) dfs(map, x + 1, y + 1);
            // 아래 왼쪽
            if (y - 1 >= 0) dfs(map, x + 1, y - 1);
        }
        // 오른쪽
        if (y + 1 < w) {
            dfs(map, x, y + 1);
            // 오른쪽 위
            if (x - 1 >= 0) dfs(map, x - 1, y + 1);
        }
        // 위
        if (x - 1 >= 0) {
            dfs(map, x - 1, y);
            // 위 왼쪽
            if (y - 1 >= 0) dfs(map, x - 1, y - 1);
        }
        if (y - 1 >= 0) dfs(map, x, y - 1);


    }
}


