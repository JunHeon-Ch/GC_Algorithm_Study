package PS_2021.카카오브레인_패스파인더_2021.Problem4;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Result {

    public static String reachTheEnd(List<String> grid, int maxTime) {
        int n = grid.size();
        int m = grid.get(0).length();
        char[][] map = new char[n][m];
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = grid.get(i).toCharArray();
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        dist[0][0] = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == '#' || dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[now.x][now.y] + 1;
                q.add(new Point(nx, ny));
            }
        }
        if(dist[n - 1][m - 1] != 0 && dist[n - 1][m - 1] - 1 <= maxTime) return "Yes";
        else return "No";
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gridCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, gridCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int maxTime = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.reachTheEnd(grid, maxTime);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
