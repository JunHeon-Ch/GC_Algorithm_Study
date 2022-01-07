package 프로그래머스.level3.카드_짝_맞추기;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/72415
 * 알고리즘: 순열 + 완탐 + BFS
 * 1. 뒤집을 그림의 순서를 정한다. (e.g., 1,2,3 or 3,1,2)
 * 2. 뒤집을 그림을 가진 2개의 카드의 순서를 정한다. (e.g, 1,2 or 2,1)
 -> 최종 방문할 카드의 순서가 정해진다 (e.g., 01 67 32 54)
 * 3. 최종 방문할 카드의 순서를 바탕으로 c1->c2의 최소 거리를 구한다.
 * 시간복잡도: O(n! * 2^n * m^2) -> n!: 순열, 2^n: 완탐, m^2: BFS
                n=6(카드 개수/2), m=4(board 배열 길이)
 */

class Solution {

    int n; // board 배열 길이
    List<Point> list = new ArrayList<>(); // 카드 리스트
    int[] seq; // 1. 뒤집을 그림의 순서를 저장하기 위한 어레이
    int[] finalSeq; // 2. 최종 방문할 카드의 순서를 저장하기 위한 어레이
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int ans = Integer.MAX_VALUE;

    public int solution(int[][] board, int r, int c) {
        n = board.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) continue;
                list.add(new Point(i, j, board[i][j]));
                cnt++;
            }
        }
        Collections.sort(list, (o1, o2) -> o1.img - o2.img);

        // 1. 뒤집을 그림의 순서를 정한다 -> 순열
        seq = new int[cnt / 2];
        for (int i = 0; i < cnt / 2; i++) {
            seq[i] = i;
        }
        do {
            finalSeq = new int[seq.length * 2];
            // 2. 뒤집을 그림을 가진 2개의 카드의 순서를 정한다 -> 완탐
            // 3. 최종 방문할 카드의 순서를 바탕으로 최소 거리를 구한다 -> BFS
            solve(board, r, c, 0);
        } while (permutation(seq));

        return ans;
    }

    // 순열 함수
    public boolean permutation(int[] seq) {
        int n = seq.length;
        int i = n - 2;
        while (i >= 0 && seq[i] > seq[i + 1]) i--;
        if (i < 0) return false;
        int min = i + 1;
        for (int j = i + 1; j < n; j++) {
            if (seq[i] < seq[j] && seq[j] < seq[min]) min = j;
        }
        swap(seq, i, min);
        for (int j = i + 1; j < n; j++) {
            min = j;
            for (int k = j + 1; k < n; k++) {
                if (seq[k] < seq[min]) min = k;
            }
            swap(seq, j, min);
        }
        return true;
    }

    public void swap(int[] seq, int i, int j) {
        int tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }

    public void solve(int[][] board, int r, int c, int idx) {
        if (idx == seq.length) {
            int[][] tmpBoard = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmpBoard[i][j] = board[i][j];
                }
            }

            // 초기 위치에서 첫번째 카드까지의 거리
            // finalSeq.length -> Enter 횟수
            int res = bfs(tmpBoard, new Point(r, c), list.get(finalSeq[0])) + finalSeq.length;
            for (int i = 0; i < finalSeq.length - 1; i++) {
                Point s = list.get(finalSeq[i]);
                Point e = list.get(finalSeq[i + 1]);
                res += bfs(tmpBoard, s, e); // 0->1->2->3... 순서로 최단 거리를 찾음
                tmpBoard[s.x][s.y] = 0;
                tmpBoard[e.x][e.y] = 0;
            }
            ans = Math.min(ans, res);
            return;
        }

        // 2. 뒤집을 그림을 가진 2개의 카드의 순서를 정한다 -> 완탐
        finalSeq[idx * 2] = seq[idx] * 2;
        finalSeq[idx * 2 + 1] = seq[idx] * 2 + 1;
        solve(board, r, c, idx + 1);
        finalSeq[idx * 2] = seq[idx] * 2 + 1;
        finalSeq[idx * 2 + 1] = seq[idx] * 2;
        solve(board, r, c, idx + 1);
    }

    // BFS 함수
    public int bfs(int[][] board, Point s, Point e) {
        int[][] dist = new int[n][n];
        Queue<Point> q = new LinkedList<>();
        q.add(s);
        dist[s.x][s.y] = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == e.x && cur.y == e.y) return dist[e.x][e.y] - 1;

            // 상하좌우로 갈 수 있는 위치
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (dist[nx][ny] > 0) continue;
                q.add(new Point(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }

            // Ctrl + 상하좌우로 갈 수 있는 위치
            for (int i = 0; i < 4; i++) {
                int nx = cur.x, ny = cur.y;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) { // 그 방향의 끝까지 갈 경우
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    if (board[nx][ny] != 0) break; // 그 방향에 가장 가까운 곳에 위치한 카드로 갈 경우
                }
                if (dist[nx][ny] > 0) continue;
                q.add(new Point(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }

        return dist[e.x][e.y] - 1;
    }
}

class Point {
    int x, y, img;

    public Point(int x, int y, int img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}