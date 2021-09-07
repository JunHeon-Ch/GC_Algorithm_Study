package 프로그래머스.lv2.게임맵최단거리;

import java.util.*;

class Solution {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static boolean[][] visit;
    public int width, height;
    //public int answer = 0;
    public int solution(int[][] maps) {
        width = maps[0].length;
        height = maps.length;

        visit = new boolean[height][width];
        visit[0][0] = true;

        bfs(0,0, maps);
        if(maps[height-1][width-1] == 1)
            return -1;
        else
            return maps[height-1][width-1];
    }
    public void bfs(int x, int y, int[][] maps){
        Queue<location> q = new LinkedList<>();
        q.add(new location(x, y));

        while(!q.isEmpty()){
            location l = q.poll();
            for(int i=0; i<4; i++){
                int nextX = l.x + dx[i];
                int nextY = l.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= height || nextY >= width) {
                    continue;
                }
                if (visit[nextX][nextY] || maps[nextX][nextY] == 0) {
                    continue;
                }

                q.add(new location(nextX, nextY));
                maps[nextX][nextY] = maps[l.x][l.y] + 1;
                //다음 좌표는 방문했음으로 표시
                visit[nextX][nextY] = true;
            }
        }

    }
}
class location {
    int x;
    int y;

    location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
