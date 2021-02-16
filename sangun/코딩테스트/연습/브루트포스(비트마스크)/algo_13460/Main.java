package algo_13460;

import java.io.*;

import java.util.StringTokenizer;

public class Main {
    static class dot {
        int x, y;

        dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean check1 = false;
    static boolean check2 = false;
    static int ans = 11;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static boolean[][] visit;
    static char[][] map;
    // 안되는 코드
    // stack이 많이 쌓이게 되면 뒤는 아예 안가는데 오류가 안나고 뒤를 돌지 않음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];
        dot a = null, b = null, o = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'R') {
                    a = new dot(i, j);
                } else if (map[i][j] == 'B') {
                    b = new dot(i, j);
                } else if (map[i][j] == 'O') {
                    o = new dot(i, j);
                }

            }
        }
        go(a, b, 0);

        if (ans == 0) ans = -1;
        if (ans > 10) ans = -1;
        bw.write(ans + "\n");
        bw.close();
    }


    static void go(dot na, dot nb, int cnt) {
        if (cnt >= 10) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nax = na.x + dx[i];
            int nay = na.y + dy[i];
            int nbx = nb.x + dx[i];
            int nby = nb.y + dy[i];

            if (i == 0) {
                if (nax < nbx) {
                    while (map[nax][nay] != '#') {
                        if (map[nax][nay] == 'O') {
                            check1 = true;
                            nax = 0;
                            nay = 0;
                            break;
                        }
                        if (nax == nb.x && nay == nb.y) break;
                        nax += dx[i];
                        nay += dy[i];
                    }
                    nax -= dx[i];
                    nay -= dy[i];

                    while (map[nbx][nby] != '#') {
                        if (map[nbx][nby] == 'O') {
                            check2 = true;
                            nbx = 0;
                            nby = 0;
                            break;
                        }
                        if (nbx == nax && nby == nay) break;
                        nbx += dx[i];
                        nby += dy[i];
                    }
                    nbx -= dx[i];
                    nby -= dy[i];
                } else {
                    while (map[nbx][nby] != '#') {
                        if (map[nbx][nby] == 'O') {
                            check2 = true;
                            nbx = 0;
                            nby = 0;
                            break;
                        }
                        if (nbx == na.x && nby == na.y) break;
                        nbx += dx[i];
                        nby += dy[i];
                    }
                    nbx -= dx[i];
                    nby -= dy[i];
                    while (map[nax][nay] != '#') {
                        if (map[nax][nay] == 'O') {
                            check1 = true;
                            nax = 0;
                            nay = 0;
                            break;
                        }
                        if (nax == nbx && nay == nby) break;
                        nax += dx[i];
                        nay += dy[i];
                    }
                    nax -= dx[i];
                    nay -= dy[i];
                }
            }
            if (i == 1) {
                if (nax > nbx) {
                    while (map[nax][nay] != '#') {
                        if (map[nax][nay] == 'O') {
                            check1 = true;
                            nax = 0;
                            nay = 0;
                            break;
                        }
                        if (nax == nb.x && nay == nb.y) break;
                        nax += dx[i];
                        nay += dy[i];
                    }
                    nax -= dx[i];
                    nay -= dy[i];

                    while (map[nbx][nby] != '#') {
                        if (map[nbx][nby] == 'O') {
                            check2 = true;
                            nbx = 0;
                            nby = 0;
                            break;
                        }
                        if (nbx == nax && nby == nay) break;
                        nbx += dx[i];
                        nby += dy[i];
                    }
                    nbx -= dx[i];
                    nby -= dy[i];
                } else {
                    while (map[nbx][nby] != '#') {
                        if (map[nbx][nby] == 'O') {
                            nbx = 0;
                            nby = 0;
                            check2 = true;
                            break;
                        }
                        if (nbx == na.x && nby == na.y) break;
                        nbx += dx[i];
                        nby += dy[i];
                    }
                    nbx -= dx[i];
                    nby -= dy[i];
                    while (map[nax][nay] != '#') {
                        if (map[nax][nay] == 'O') {
                            check1 = true;
                            nax = 0;
                            nay = 0;
                            break;
                        }
                        if (nax == nbx && nay == nby) break;
                        nax += dx[i];
                        nay += dy[i];
                    }
                    nax -= dx[i];
                    nay -= dy[i];
                }
            }
            if (i == 2) {
                if (nay < nby) {
                    while (map[nax][nay] != '#') {
                        if (map[nax][nay] == 'O') {
                            check1 = true;
                            nax = 0;
                            nay = 0;
                            break;
                        }
                        if (nax == nb.x && nay == nb.y) break;
                        nax += dx[i];
                        nay += dy[i];
                    }
                    nax -= dx[i];
                    nay -= dy[i];

                    while (map[nbx][nby] != '#') {
                        if (map[nbx][nby] == 'O') {
                            check2 = true;
                            nbx = 0;
                            nby = 0;
                            break;
                        }
                        if (nbx == nax && nby == nay) break;
                        nbx += dx[i];
                        nby += dy[i];
                    }
                    nbx -= dx[i];
                    nby -= dy[i];
                } else {
                    while (map[nbx][nby] != '#') {
                        if (map[nbx][nby] == 'O') {
                            nbx = 0;
                            nby = 0;
                            check2 = true;
                            break;
                        }
                        if (nbx == na.x && nby == na.y) break;
                        nbx += dx[i];
                        nby += dy[i];
                    }
                    nbx -= dx[i];
                    nby -= dy[i];
                    while (map[nax][nay] != '#') {
                        if (map[nax][nay] == 'O') {
                            check1 = true;
                            nax = 0;
                            nay = 0;
                            break;
                        }
                        if (nax == nbx && nay == nby) break;
                        nax += dx[i];
                        nay += dy[i];
                    }
                    nax -= dx[i];
                    nay -= dy[i];
                }
            }
            if (i == 3) {
                if (nay > nby) {
                    while (map[nax][nay] != '#') {
                        if (map[nax][nay] == 'O') {
                            check1 = true;
                            nax = 0;
                            nay = 0;
                            break;
                        }
                        if (nax == nb.x && nay == nb.y) break;
                        nax += dx[i];
                        nay += dy[i];
                    }
                    nax -= dx[i];
                    nay -= dy[i];

                    while (map[nbx][nby] != '#') {
                        if (map[nbx][nby] == 'O') {
                            check2 = true;
                            nbx = 0;
                            nby = 0;
                            break;
                        }
                        if (nbx == nax && nby == nay) break;
                        nbx += dx[i];
                        nby += dy[i];
                    }
                    nbx -= dx[i];
                    nby -= dy[i];
                } else {
                    while (map[nbx][nby] != '#') {
                        if (map[nbx][nby] == 'O') {
                            check2 = true;
                            nbx = 0;
                            nby = 0;
                            break;
                        }
                        if (nbx == na.x && nby == na.y) break;
                        nbx += dx[i];
                        nby += dy[i];
                    }
                    nbx -= dx[i];
                    nby -= dy[i];
                    while (map[nax][nay] != '#') {
                        if (map[nax][nay] == 'O') {
                            check1 = true;
                            nax = 0;
                            nay = 0;
                            break;
                        }
                        if (nax == nbx && nay == nby) break;
                        nax += dx[i];
                        nay += dy[i];
                    }
                    nax -= dx[i];
                    nay -= dy[i];
                }
            }

            // x
            if (check1 && check2) {
                check1 = false;
                check2 = false;
                return;
            } else if (check1) { // 정답인 경우
                check1 = false;
                check2 = false;
                cnt++;
                if (ans != 0) {
                    ans = Math.min(ans, cnt);
                } else ans = cnt;
                return;
            } else if (check2) {
                check1 = false;
                check2 = false;
                return;
            }
            go(new dot(nax, nay), new dot(nbx, nby), cnt + 1);
        }

    }


}

