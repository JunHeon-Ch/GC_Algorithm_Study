package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class no1261 {
    public static int N;
    public static int M;
    public static int[][] maze;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        System.out.println(bfs());
    }
    public static int bfs(){
        int[][] visited = new int[N][M];
        Queue<Manager> queue = new LinkedList<Manager>();

        // x, y 까지 왔을 때 벽을 부순 최소 개수를 표시하기 위해 전제 배열의 값 최대로 초기화
        for (int i = 0; i < N; i++)
            Arrays.fill(visited[i], 987654321);

        visited[0][0] = 0;
        queue.add(new Manager(0, 0, 0));

        while (!queue.isEmpty()) {
            Manager current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int breakCnt = current.breakCnt;

                // 방의 범의 범위를 벗어나면 안됨
                if (!isIn(nx, ny))
                    continue;

                // 목적지에 도착했을 때
                if (nx == N - 1 && ny == M - 1) {
                    // 목적지까지 왔을 때 부순벽의 개수를 저장되어있는 값이랑 비교해서 더 작은 값 저장
                    visited[nx][ny] = Math.min(breakCnt, visited[nx][ny]);
                    continue;
                }

                // 다음에 가야할 칸이 벽이면 부숨
                if (maze[nx][ny] == 1)
                    breakCnt += 1;

                // 누군가가 이미 그 칸으로 이동했을 때 저장한 부순 벽의 개수 <= 다음 칸으로 이동하기 위해 벽을 부순 개수
                if (visited[nx][ny] <= breakCnt)
                    continue;

                // 이미 저장된 값보다 더 적게 부숴야 그 칸으로 이동할 수 있음
                queue.add(new Manager(nx, ny, breakCnt));
                visited[nx][ny] = breakCnt;
            }
        }

        return visited[N - 1][M - 1];
    }
    public static boolean isIn(int x, int y) {
        if (0 <= x && x < N && 0 <= y && y < M)
            return true;
        return false;
    }
}
class Manager implements Comparable<Manager>{
    int x;
    int y;
    int breakCnt;
    public Manager(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.breakCnt = cnt;
    }
    public void breakWall() {
        this.breakCnt += 1;
    }

    @Override
    public int compareTo(Manager o) {
        return 0;
    }
}
