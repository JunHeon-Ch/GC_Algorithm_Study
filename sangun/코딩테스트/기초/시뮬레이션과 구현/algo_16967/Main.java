package algo_16967;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] b = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w + y; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] a = new int[h][w];
        for (int i = 0; i < h + x; i++) {
            for (int j = 0; j < w + y; j++) {
                // up
                if (i < x && j < w) {
                    a[i][j] = b[i][j];
                }
                // left
                if (i >= x && i < h && j < y) {
                    a[i][j] = b[i][j];
                }
                // right
                if (i >= x && i < h && j >= w) {
                    a[i - x][j - y] = b[i][j];
                }
                // down
                if (i >= h && j >= y) {
                    a[i - x][j - y] = b[i][j];
                }
                // blank
                if (i >= x && i < h && j >= y && j < w) {
                    a[i][j] = b[i][j] - a[i - x][j - y];
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write(a[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();

    }
}
