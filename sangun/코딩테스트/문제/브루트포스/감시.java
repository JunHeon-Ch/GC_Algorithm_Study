package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 감시 {
    static int n, m;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = n * m;
        int[][] map = new int[n][m];

        ArrayList<Pair> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    s.add(new Pair(i, j, map[i][j]));
                }
            }
        }
        go(0, map, s);
        System.out.println(ans);


    }

    static void go(int index, int[][] board, ArrayList<Pair> s) {
        if (index == s.size()) {
            ans = Math.min(ans, result(board));

            return;
        }
        int[][] temp = new int[n][m];
        copy(temp, board);

        Pair p = s.get(index);
        if (p.z == 1) {
            for (int i = 0; i < 4; i++) {
                go(index + 1, cal(board, p.z, i, p.x, p.y), s);
                copy(board, temp);

            }
        } else if (p.z == 2) {
            for (int i = 0; i < 2; i++) {
                go(index + 1, cal(board, p.z, i, p.x, p.y), s);
                board = temp.clone();
                copy(board, temp);
            }

        } else if (p.z == 3) {
            for (int i = 0; i < 4; i++) {
                go(index + 1, cal(board, p.z, i, p.x, p.y), s);
                board = temp.clone();
                copy(board, temp);
            }

        } else if (p.z == 4) {
            for (int i = 0; i < 4; i++) {
                go(index + 1, cal(board, p.z, i, p.x, p.y), s);
                board = temp.clone();
                copy(board, temp);
            }

        } else if (p.z == 5) {
            go(index + 1, cal(board, p.z, 5, p.x, p.y), s);
            copy(board, temp);
        }


    }

    static int[][] cal(int[][] w, int camera, int dir, int x, int y) {
        int[][] board = new int[n][m];
        copy(board,w);
        if (camera == 1) {
            if (dir == 0) {
                // 상
                for (int i = x - 1; i >= 0; i--) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
            } else if (dir == 1) {

                // 하
                for (int i = x + 1; i < n; i++) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
            } else if (dir == 2) {

                // 우
                for (int i = y + 1; i < m; i++) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
            } else {
                // 좌
                for (int i = y - 1; i >= 0; i--) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }

            }
        }
        else if (camera == 2) {
            if (dir == 0) {
                // 상
                for (int i = x - 1; i >= 0; i--) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 하
                for (int i = x + 1; i < n; i++) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
            } else {

                // 우
                for (int i = y + 1; i < m; i++) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
                // 좌
                for (int i = y - 1; i >= 0; i--) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }

            }

        }
        else if (camera == 3) {
            // 상+좌
            if (dir == 0) {
                // 상
                for (int i = x - 1; i >= 0; i--) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 좌
                for (int i = y - 1; i >= 0; i--) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
            }
            // 상+우
            else if (dir == 1) {
                // 상
                for (int i = x - 1; i >= 0; i--) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 우
                for (int i = y + 1; i < m; i++) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
            }
            // 하+좌
            else if (dir == 2) {
                // 하
                for (int i = x + 1; i < n; i++) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 좌
                for (int i = y - 1; i >= 0; i--) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
            }
            // 하+우
            else if (dir == 3) {
                // 하
                for (int i = x + 1; i < n; i++) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 우
                for (int i = y + 1; i < m; i++) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
            }
        }
        else if (camera == 4) {
            // 상+좌+우
            if (dir == 0) {
                // 상
                for (int i = x - 1; i >= 0; i--) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 좌
                for (int i = y - 1; i >= 0; i--) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
                // 우
                for (int i = y + 1; i < m; i++) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
            }
            // 상+하+좌
            else if (dir == 1) {
                // 상
                for (int i = x - 1; i >= 0; i--) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 하
                for (int i = x + 1; i < n; i++) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 좌
                for (int i = y - 1; i >= 0; i--) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
            }
            // 하+좌+우
            else if (dir == 2) {
                // 하
                for (int i = x + 1; i < n; i++) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 좌
                for (int i = y - 1; i >= 0; i--) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
                // 우
                for (int i = y + 1; i < m; i++) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
            }
            // 상+하+우
            else if (dir==3){
                // 상
                for (int i = x - 1; i >= 0; i--) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 하
                for (int i = x + 1; i < n; i++) {
                    if (board[i][y] == 6) {
                        break;
                    }
                    board[i][y] = -1;
                }
                // 우
                for (int i = y + 1; i < m; i++) {
                    if (board[x][i] == 6) {
                        break;
                    }
                    board[x][i] = -1;
                }
            }
        }
        else if (camera == 5) {

            // 상
            for (int i = x - 1; i >= 0; i--) {
                if (board[i][y] == 6) {
                    break;
                }
                board[i][y] = -1;
            }
            // 좌
            for (int i = y - 1; i >= 0; i--) {
                if (board[x][i] == 6) {
                    break;
                }
                board[x][i] = -1;
            }
            // 하
            for (int i = x + 1; i < n; i++) {
                if (board[i][y] == 6) {
                    break;
                }
                board[i][y] = -1;
            }
            // 우
            for (int i = y + 1; i < m; i++) {
                if (board[x][i] == 6) {
                    break;
                }
                board[x][i] = -1;
            }

        }

        return board;
    }

    static int result(int[][] board) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) total++;

            }
        }
        return total;
    }

    private static void copy(int[][] newMap, int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMap[i][j] = map[i][j];
            }
        }

    }


    static class Pair {
        int x, y, z;

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}

