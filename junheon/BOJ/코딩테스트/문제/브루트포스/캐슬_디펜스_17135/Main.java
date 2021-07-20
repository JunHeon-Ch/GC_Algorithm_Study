package BOJ.코딩테스트.문제.브루트포스.캐슬_디펜스_17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Enemy {
    int x, y;
    boolean death;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.death = false;
    }

    public Enemy(Enemy enemy) {
        x = enemy.x;
        y = enemy.y;
        death = false;
    }
}

public class Main {

    static int N, M, D;
    static int[][] board;
    static List<Enemy> enemyList;
    static int ans = 0;

    public static int attack() {
        List<Enemy> eList = new ArrayList<>();
        for(Enemy enemy : enemyList) {
            eList.add(new Enemy(enemy));
        }

        int death = 0;
        while (eList.size() > 0) {
            for (int k = 0; k < M; k++) {
                if (board[N][k] == 2) {
                    Enemy delEnemy = null;
                    int dist = Integer.MAX_VALUE;
                    for (int i = 0; i < eList.size(); i++) {
                        Enemy enemy = eList.get(i);
                        int d = Math.abs(enemy.x - N) + Math.abs(enemy.y - k);
                        if (d <= D) {
                            if (delEnemy == null) {
                                delEnemy = enemy;
                                dist = d;
                            } else if (dist > d) {
                                delEnemy = enemy;
                                dist = d;
                            } else if (dist == d && delEnemy.y > enemy.y) {
                                delEnemy = enemy;
                            }
                        }
                    }
                    if (delEnemy != null) {
                        delEnemy.death = true;
                    }
                }
            }
            for (int i = 0; i < eList.size(); i++) {
                Enemy enemy = eList.get(i);
                enemy.x++;
                if (enemy.death) {
                    death++;
                }
                if (enemy.death || enemy.x == N) {
                    eList.remove(enemy);
                    i--;
                }
            }
        }
        return death;
    }

    public static void solve(int index, int start) {
        if (index == 3) {
            int res = attack();
            ans = Math.max(ans, res);
            return;
        }
        for (int j = start; j < M; j++) {
            if (board[N][j] == 0) {
                board[N][j] = 2;
                solve(index + 1, j + 1);
                board[N][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        board = new int[N + 1][M];
        enemyList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) {
                    enemyList.add(new Enemy(i, j));
                }
            }
        }
        solve(0, 0);
        System.out.println(ans);
    }
}
