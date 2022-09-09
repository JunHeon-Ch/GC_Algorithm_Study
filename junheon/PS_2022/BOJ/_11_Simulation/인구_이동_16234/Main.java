package PS_2022.BOJ._11_Simulation.인구_이동_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/16234
 * 알고리즘: 시뮬레이션
 * 시간복잡도: O(n^2), n=50(행,열)
 */

public class Main {

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int l, r;
    static int[][] population;
    static int[][] group;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        population = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true) {
            Map<Integer, Integer> map = new HashMap<>();
            group = new int[n][n];
            int num = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(group[i][j] != 0) continue;
                    int res = bfs(i, j, ++num);
                    if(res != -1) map.put(num, res);
                }
            }
            if(map.isEmpty()) break;
            for(int key : map.keySet()) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(group[i][j] == key) population[i][j] = map.get(key);
                    }
                }
            }
            day++;
        }
        System.out.println(day);
    }

    static int bfs(int x, int y, int num) {
        int sum = 0, cnt = 0;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        group[x][y] = num;
        sum += population[x][y];
        while(!q.isEmpty()) {
            cnt++;
            Pos now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(group[nx][ny] != 0) continue;
                int val = Math.abs(population[now.x][now.y] - population[nx][ny]);
                if(val >= l && val <= r) {
                    q.add(new Pos(nx, ny));
                    group[nx][ny] = num;
                    sum += population[nx][ny];
                }
            }
        }

        if(cnt < 2) return -1;
        return sum / cnt;
    }
}
