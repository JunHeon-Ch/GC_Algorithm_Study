package BOJ.코딩테스트.문제.브루트포스.십자가_찾기_16924;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Cross {
    int x, y, s;

    public Cross(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        boolean[][] check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(board[i][j] == '*') check[i][j] = true;
            }
        }
        br.close();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        List<Cross> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == '*') {
                    int scale = 1;
                    while(true) {
                        boolean flag = true;
                        for(int k = 0; k < 4; k++) {
                            int nx = i + dx[k] * scale;
                            int ny = j + dy[k] * scale;
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] != '*') {
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) break;
                        for(int k = 0; k < 4; k++) {
                            int nx = i + dx[k] * scale;
                            int ny = j + dy[k] * scale;
                            check[nx][ny] = false;
                        }
                        check[i][j] = false;
                        list.add(new Cross(i + 1, j + 1, scale));
                        scale++;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(check[i][j]) {
                    bw.write(-1 + "\n");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.write(list.size() + "\n");
        for(Cross cross : list) {
            bw.write(cross.x + " " + cross.y + " " + cross.s + "\n");
        }
        bw.flush();
        bw.close();
    }
}
