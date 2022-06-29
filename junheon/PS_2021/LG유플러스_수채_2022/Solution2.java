package PS_2021.LG유플러스_수채_2022;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 문제 설명
 * 0과 1로만 이루어져 있는 maps이 주어졌을 때, 상하좌우 연결되어 있는 칸을 같은 섬으로 분류하고 이 모든 섬의 둘레의 합을 구하라

 * 알고리즘: BFS
 * 시간복잡도: O(n*m), n=100(maps 배열 행 길이), m=100(maps 배열 열 길이)
 */

class Solution2 {

    int n, m;
    int[][] group; // 섬을 나누기 위한 배열
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        group = new int[n][m];
        int groupNum = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i][j] == 1 && group[i][j] == 0) {
                    bfs(maps, new Point(i, j), groupNum); // 연결된 모든 땅은 같은 섬 번호(groupNum)을 가진다.
                    groupNum++;
                }
            }
        }

        return calc(); // 모든 섬의 둘레 합을 구한다.
    }

    public void bfs(int[][] map, Point s, int num) {
        Queue<Point> q = new LinkedList<>();
        q.add(s);
        group[s.x][s.y] = num;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == 0 || group[nx][ny] != 0) continue;
                q.add(new Point(nx, ny));
                group[nx][ny] = num;
            }
        }
    }

    // 섬의 둘레는 상하좌우 중 maps 외부이거나 다른 섬or바다(0)일 경우 + 1
    public int calc() {
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[i];
                    int ny = j + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) res++; // maps 외부일 경우
                    else if(group[i][j] != group[nx][ny]) res++; // 다른 섬or바다(0)일 경우
                }
            }
        }
        return res;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
