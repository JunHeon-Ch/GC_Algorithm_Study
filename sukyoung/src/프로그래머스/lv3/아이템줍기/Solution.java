package 프로그래머스.lv3.아이템줍기;

import java.util.*;

class Solution {
    public ArrayList<location> list = new ArrayList<>();
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, -1, 0, 1};
    public int[][] map = new int[102][102];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        for(int i=0; i<rectangle.length; i++) {
            int sx = rectangle[i][0]*2;
            int sy = rectangle[i][1]*2;
            int ex = rectangle[i][2]*2;
            int ey = rectangle[i][3]*2;

            for(int y=sy; y<=ey; y++) {
                for(int x=sx; x<=ex; x++) {
                    map[y][x] = -1;
                }
            }
            list.add(new location(sx,sy,ex,ey));
        }

        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }
    public int bfs(int x, int y, int tx, int ty){
        Queue<dot> queue = new LinkedList<>();
        queue.add(new dot(x, y, 1));
        map[y][x] = 1;

        while(!queue.isEmpty()){
            dot now = queue.poll();

            if(now.x == tx && now.y == ty)
                return now.move / 2;

            for(int i=0; i<4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];

                if(map[next_y][next_x] < 0 && isBoundary(next_x, next_y)){
                    map[next_y][next_x] = now.move + 1;
                    queue.add(new dot(next_x, next_y, now.move+1));
                }
            }
        }
        return 0;
    }

    public boolean isBoundary(int x, int y){
        for(location r : list) {
            if(r.x1 < x && r.y1 <y && r.x2 > x && r.y2 > y)
                return false;
        }
        return true;
    }
}
class dot{
    int x;
    int y;
    int move;
    public dot(int x, int y, int move){
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
class location{
    int x1, x2, y1, y2;
    public location(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}