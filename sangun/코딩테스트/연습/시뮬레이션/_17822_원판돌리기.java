import java.io.*;
import java.util.StringTokenizer;

public class _17822_원판돌리기 {
    static int[][] circle;
    static int n, m, t;
    static boolean check = false;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        circle = new int[n][m];
        int x, d, k;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= n; j++) {
                if (j % x == 0) {
                    rotate(j - 1, d, k);
                }
            }
            find();
        }
        System.out.println(sum());

    }

    public static void rotate(int x, int d, int k) {
        int[] rotate = new int[m];
        int index;
        for (int i = 0; i < m; i++) {
            index = calculateIndex(d, i, k);
            rotate[index] = circle[x][i];
        }
        circle[x] = rotate;

    }

    public static void find() {
        boolean valid = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check = false;
                if (circle[i][j] != 0) {
                    dfs(i, j, circle[i][j]);
                }
                if (check) {
                    circle[i][j] = 0;
                    valid = true;
                }
            }
        }
        if (!valid) {
            calculate();
        }

    }

    public static void dfs(int x, int y, int num) {
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = (y + dy[i]) % m;
            if (ny < 0) {
                ny = m - 1;
            }
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (circle[nx][ny] == num) {
                    check = true;
                    circle[nx][ny] = 0;
                    dfs(nx, ny, num);
                }
            }
        }
    }

    public static int calculateIndex(int d, int i, int k) {
        if (d == 0) {
            return (i + k) % m;
        }
        if (i - k < 0) {
            return m + (i - k);
        }
        return i - k;
    }

    public static void calculate() {
        double sum = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle[i][j] != 0) {
                    sum += circle[i][j];
                    cnt++;
                }
            }
        }

        double average = sum / cnt;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle[i][j] != 0 && circle[i][j] < average) {
                    circle[i][j] += 1;
                } else if (circle[i][j] != 0 && circle[i][j] > average) {
                    circle[i][j] -= 1;
                }
            }
        }
    }

    public static int sum() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += circle[i][j];
            }
        }
        return sum;
    }

}