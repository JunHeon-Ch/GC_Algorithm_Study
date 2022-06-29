package PS_2021.BOJ.시뮬레이션.인구_이동_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/16234
 * 알고리즘: 시뮬레이션, BFS
 * 시간복잡도: O(m*n^2), m=2000(최대 인구 이동 일수), n=50(땅 가로/세로 크기)
 */

public class Main {

    static int n, l, r;
    static int[][] map;
    static int[][] group;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while(true) {
            group = new int[n][n];
            visit = new boolean[n][n];
            int num = 1;
            List<Integer> list = new ArrayList<>(); // 연합국의 인구수를 저장하기 위한 리스트
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(group[i][j] == 0 && !visit[i][j]) {
                        int res = bfs(new Point(i, j), num++); // 연합국을 확인하고 연합국의 인구수 반환
                        if(res == 0) num--; // 연합국이 하나일 경우
                        else list.add(res);
                    }
                }
            }

            boolean change = false;
            for(int k = 1; k < num; k++) {
                int population = list.get(k - 1); // 연합국의 인구수
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(group[i][j] == k) {
                            map[i][j] = population;
                            change = true;
                        }
                    }
                }
            }
            if(!change) break; // 인구 이동이 일어나지 않으면 끝
            ans++;
        }
        System.out.println(ans);
    }

    public static int bfs(Point p, int groupNum) {
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        group[p.x][p.y] = groupNum;
        visit[p.x][p.y] = true;
        int sum = map[p.x][p.y]; // 연합의 인구수
        int cnt = 1; // 연합을 이루고 있는 칸의 수
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(group[nx][ny] != 0 || visit[nx][ny]) continue;
                int diff = Math.abs(map[nx][ny] - map[cur.x][cur.y]);
                if(diff < l || r < diff) continue;
                q.add(new Point(nx, ny));
                group[nx][ny] = groupNum;
                visit[nx][ny] = true;
                sum += map[nx][ny];
                cnt++;
            }
        }
        if(cnt == 1) { // 연합이 한 칸일 경우 연합을 이루지 않는다
            group[p.x][p.y] = 0;
            return 0;
        }
        return sum / cnt;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
