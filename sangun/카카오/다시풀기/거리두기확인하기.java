package 다시풀기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] answer = new int[places.length];

        int idx = 0;
        for (String[] place : places) {
            ArrayList<Pair> arr = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') arr.add(new Pair(i, j));
                }
            }
            answer[idx++] = bfs(place, arr);

        }
        System.out.println(Arrays.toString(answer));

    }

    static int bfs(String[] place, ArrayList<Pair> person) {
        for (int i = 0; i < person.size(); i++) {
            Queue<Pair> q = new LinkedList<>();
            q.add(person.get(i));
            int[][] visited = new int[5][5];
            visited[person.get(i).x][person.get(i).y] = 1;

            while (!q.isEmpty()) {
                Pair p = q.remove();

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 5 || nx < 0 || ny >= 5 || ny < 0) continue;
                    if (visited[nx][ny] != 0) continue;
                    if (place[nx].charAt(ny) == 'X') continue;
                    if (place[nx].charAt(ny) == 'P') {
                        if (visited[p.x][p.y] + 1 <= 2) return 0;

                    }
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
        return 1;

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
