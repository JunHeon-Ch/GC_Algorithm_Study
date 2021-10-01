package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no4179 {
    public static Queue<point> fire, list;
    public static point start;
    public static char[][] map;
    public static int r, c, result;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        fire = new LinkedList<>();
        list = new LinkedList<>();
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = str.charAt(j);

                if(str.charAt(j) == 'J'){
                    list.add(new point(i, j, 0));
                }
                else if(str.charAt(j) == 'F') {
                    fire.add(new point(i, j, 0));
                }
            }
        }

        if(bfs())
            System.out.println(result);
        else
            System.out.println("IMPOSSIBLE");

    }

    public static boolean bfs(){
        while (!list.isEmpty()){

            int size = fire.size();
            for(int i=0; i<size; i++){
                point now = fire.poll();

                for(int j=0; j<4; j++){
                    int next_x = now.x + dx[j];
                    int next_y = now.y + dy[j];

                    if(next_x < 0 || next_y < 0 || next_x >= r || next_y >= c)
                        continue;
                    if(map[next_x][next_y] == '#' || map[next_x][next_y] == 'F')
                        continue;

                    map[next_x][next_y] = 'F';
                    fire.add(new point(next_x, next_y, now.cnt + 1));
                }
            }

            size = list.size();
            for(int i=0; i<size; i++){
                point now = list.poll();

                for(int j=0; j<4; j++){
                    int next_x = now.x + dx[j];
                    int next_y = now.y + dy[j];

                    if(next_x < 0 || next_y < 0 || next_x >= r || next_y >= c){
                        result = now.cnt+1;
                        return true;
                    }

                    if(map[next_x][next_y] == '#' || map[next_x][next_y] == 'F' || map[next_x][next_y] == 'J')
                        continue;

                    map[next_x][next_y] = 'J';
                    list.add(new point(next_x, next_y, now.cnt + 1));
                }
            }
        }
        return false;
    }
}

class point{
    int x;
    int y;
    int cnt;
    point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
