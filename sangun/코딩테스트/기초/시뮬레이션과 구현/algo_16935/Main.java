package algo_16935;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] cal = new int[r];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }
        int[][] ans = new int[n][m];

        int row = m, col = n;
        for (int t = 0; t < r; t++) {
            switch (cal[t]) {
                case 1:
                    for (int i = 0; i < n / 2; i++) {
                        for (int j = 0; j < m; j++) {
                            int temp = map[i][j];
                            map[i][j] = map[n - 1 - i][j];
                            map[n - 1 - i][j] = temp;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m / 2; j++) {
                            int temp = map[i][j];
                            map[i][j] = map[i][m - 1 - j];
                            map[i][m - 1 - j] = temp;
                        }
                    }
                    break;
                case 3:
                    row = n;
                    col = m;
                    n = m;
                    m = row;

                    ans = new int[n][m];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            ans[j][row - 1 - i] = map[i][j];
                        }
                    }
                    map = new int[n][m];
                    map = ans;
                    break;
                case 4:
                    row = n;
                    col = m;
                    n = m;
                    m = row;

                    ans = new int[n][m];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            ans[col - j - 1][i] = map[i][j];
                        }
                    }
                    map = new int[n][m];
                    map = ans;
                    break;
                case 5:
                    ans = new int[n][m];
                    // 1 -> 2
                    for (int i = 0; i < n / 2; i++) {
                        for (int j = 0; j < m / 2; j++) {
                            ans[i][j + m / 2] = map[i][j];
                        }
                    }
                    // 2 -> 3
                    for (int i = 0; i < n / 2; i++) {
                        for (int j = m / 2; j < m; j++) {
                            ans[i + n / 2][j] = map[i][j];
                        }
                    }
                    // 3 -> 4
                    for (int i = n / 2; i < n; i++) {
                        for (int j = m / 2; j < m; j++) {
                            ans[i][j - m / 2] = map[i][j];
                        }
                    }
                    // 4 -> 1
                    for (int i = n / 2; i < n; i++) {
                        for (int j = 0; j < m / 2; j++) {
                            ans[i - n / 2][j] = map[i][j];
                        }
                    }

                    map = ans;
                    break;
                case 6:
                    ans = new int[n][m];
                    // 1 -> 4
                    for (int i = 0; i < n / 2; i++) {
                        for (int j = 0; j < m / 2; j++) {
                            ans[i + n / 2][j] = map[i][j];
                        }
                    }
                    // 2 -> 1
                    for (int i = 0; i < n / 2; i++) {
                        for (int j = m / 2; j < m; j++) {
                            ans[i][j - m / 2] = map[i][j];
                        }
                    }
                    // 3 -> 2
                    for (int i = n / 2; i < n; i++) {
                        for (int j = m / 2; j < m; j++) {
                            ans[i - n / 2][j] = map[i][j];
                        }
                    }
                    // 4 -> 3
                    for (int i = n / 2; i < n; i++) {
                        for (int j = 0; j < m / 2; j++) {
                            ans[i][j + m / 2] = map[i][j];
                        }
                    }

                    map = ans;
                    break;
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();

    }
}

