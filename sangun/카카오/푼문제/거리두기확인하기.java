package 푼문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            ArrayList<Pair> q = go(places[i]);
            if (q.isEmpty()) answer[i] = 1;
            else {
                for (int j = 0; j < q.size(); j++) {
                    if (!valid(places[i], q.get(0))) {
                        answer[i] = 0;
                        break;
                    } else {
                        answer[i] = 1;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(answer));

    }

    static boolean valid(String[] map, Pair pair) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(pair.x, pair.y));
        boolean[][] visited = new boolean[5][5];
        visited[pair.x][pair.y] = true;
        int[][] d = new int[5][5];


        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (visited[nx][ny]) continue;
                if (map[nx].charAt(ny) == 'X') continue;

                visited[nx][ny] = true;
                d[nx][ny] = d[p.x][p.y] + 1;
                if (map[nx].charAt(ny) == 'P') {
                    return d[nx][ny] >= 3;
                }
                q.add(new Pair(nx, ny));

            }
        }
        return true;
    }

    static ArrayList<Pair> go(String[] str) {
        ArrayList<Pair> q = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length(); j++) {
                if (str[i].charAt(j) == 'P') {
                    q.add(new Pair(i, j));
                }
            }
        }
        return q;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
