package PS_2022.BOJ._09_Graph_Traversal.봄버맨_16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char map[][];
    static int r, c, n;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static Queue<Node> q = new LinkedList<>();
    static int bombtime[][];
    static int time = 1;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        bombtime = new int[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    q.add(new Node(i, j));
                    bombtime[i][j] = 3;
                }
            }
        }

        while (time++ < n) {
            if (time % 2 == 0) setbomb();
            else getbomb();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void getbomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (bombtime[i][j] == time) {
                    map[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                        if (map[nx][ny] == '.' || bombtime[nx][ny] == time) continue;
                        bombtime[nx][ny] = 0;
                        map[nx][ny] = '.';
                    }
                }
            }
        }
    }

    public static void setbomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                    bombtime[i][j] = time + 3;
                }
            }
        }
    }
}