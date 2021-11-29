package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no3055 {
    public static char[][] map;
    public static Queue<move> water, dochi;
    public static move beaver;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        dochi = new LinkedList<>();
        water = new LinkedList<>();
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = str.charAt(j);
                if(str.charAt(j) == 'S')
                    dochi.add(new move(i, j, 0));
                else if(str.charAt(j) == '*')
                    water.add(new move(i, j, 0));
                else if(str.charAt(j) == 'D')
                    beaver = new move(i, j, 0);
            }
        }
        bfs(r, c);
        System.out.print(sb);
    }

    public static void bfs(int r, int c){
        while(!dochi.isEmpty()){

            int size = water.size();
            for(int i=0; i<size; i++){
                move now = water.poll();

                for(int j=0; j<4; j++){
                    int next_x = now.x + dx[j];
                    int next_y = now.y + dy[j];

                    if(next_x < 0 || next_y < 0 || next_x >= r || next_y >= c)
                        continue;
                    if(map[next_x][next_y] == 'X' || map[next_x][next_y] == '*' || map[next_x][next_y] == 'D')
                        continue;

                    map[next_x][next_y] = '*';
                    water.add(new move(next_x, next_y, now.cnt+1));
                }
            }

            size = dochi.size();
            for(int i=0; i<size; i++){
                move now = dochi.poll();

                if(now.x == beaver.x && now.y == beaver.y) {
                    sb.append(now.cnt);
                    return;
                }

                for(int j=0; j<4; j++){
                    int next_x = now.x + dx[j];
                    int next_y = now.y + dy[j];

                    if(next_x < 0 || next_y < 0 || next_x >= r || next_y >= c)
                        continue;
                    if(map[next_x][next_y] == '*' || map[next_x][next_y] == 'X' || map[next_x][next_y] == 'S')
                        continue;

                    map[next_x][next_y] = 'S';
                    dochi.add(new move(next_x, next_y, now.cnt+1));
                }
            }
        }
        sb.append("KAKTUS");
    }
}

class move {
    int x;
    int y;
    int cnt;
    move(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}