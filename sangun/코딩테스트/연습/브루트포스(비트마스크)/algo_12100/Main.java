package algo_12100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, ans = 0;
    static int[][] map;
    // 2차원 배열 clone 할때 조심하기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        bw.write(ans + "\n");
        bw.close();
    }

    static void dfs(int cnt) {
        if (cnt == 5) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > temp) {
                        temp = map[i][j];
                    }
                }
            }
            ans = Math.max(ans, temp);
            return;
        }

        int[][] temp = new int[n][n];
        for (int a = 0; a < n; a++)
            temp[a] = map[a].clone();

        for (int i = 0; i < 4; i++) {
            calculation(i);
            dfs(cnt + 1);
            for (int a = 0; a < n; a++)
                map[a] = temp[a].clone();
        }
    }

    static void calculation(int dir) {
        // 상
        // index는 값을 넣을 위치, block은 최근 블록의 값
        if (dir == 0) {
            for (int j = 0; j < n; j++) {
                int index = 0;
                int block = 0;
                for (int i = 0; i < n; i++) {
                    if (map[i][j] != 0) {
                        if (block == map[i][j]) {
                            map[index - 1][j] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        } else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[index][j] = block;
                            index++;
                        }
                    }
                }
            }
        } // 하
        else if (dir == 1) {
            for (int j = 0; j < n; j++) {
                int index = n - 1;
                int block = 0;
                for (int i = n - 1; i >= 0; i--) {
                    if (map[i][j] != 0) {
                        if (block == map[i][j]) {
                            map[index + 1][j] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        } else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[index][j] = block;
                            index--;
                        }
                    }
                }
            }
        } // 좌
        else if (dir == 2) {
            for (int i = 0; i < n; i++) {
                int index = 0;
                int block = 0;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0) {
                        if (block == map[i][j]) {
                            map[i][index - 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        } else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index++;
                        }
                    }
                }
            }
        }// 우
        else if (dir == 3) {
            for (int i = 0; i < n; i++) {
                int index = n - 1;
                int block = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (map[i][j] != 0) {
                        if (block == map[i][j]) {
                            map[i][index + 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        } else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index--;
                        }
                    }
                }
            }
        }
    }
}
