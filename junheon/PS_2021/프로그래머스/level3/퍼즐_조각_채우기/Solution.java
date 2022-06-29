package PS_2021.프로그래머스.level3.퍼즐_조각_채우기;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/84021
 * 알고리즘: 구현/시뮬레이션
 * 시간복잡도: O(n^2), n=50(game_board와 table 행의 길이)
 */
class Solution {

    int len;
    List<List<Point>> board = new ArrayList<>(); // game_board의 빈칸 저장
    List<List<Point>> block = new ArrayList<>(); // table의 block 저장
    boolean[][] visit;

    public int solution(int[][] game_board, int[][] table) {
        len = game_board.length;

        // table의 block 저장
        // O(n^2)
        visit = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(!visit[i][j] && table[i][j] == 1) {
                    block.add(bfs(table, i, j, 1));
                }
            }
        }

        // game_board의 빈칸 저장
        // O(n^2)
        visit = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(!visit[i][j] && game_board[i][j] == 0) {
                    board.add(bfs(game_board, i, j, 0));
                }
            }
        }

        boolean[] check = new boolean[board.size()]; // 빈칸이 채워져 있는지 확인
        int ans = 0;
        for(int i = 0; i < block.size(); i++) {
            List<Point> blockElem = block.get(i);
            for(int j = 0; j < board.size(); j++) {
                List<Point> boardElem = board.get(j);
                if(check[j] || boardElem.size() != blockElem.size()) continue;
                if(fit(boardElem, blockElem)) {
                    ans += blockElem.size();
                    check[j] = true;
                    break;
                }
            }
        }
        return ans;
    }

    public List<Point> bfs(int[][] board, int x, int y, int type) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        List<Point> res = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        res.add(new Point(0, 0)); // (x,y)를 (0,0)로 변환
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= len || ny < 0 || ny >= len) continue;
                if(visit[nx][ny] || board[nx][ny] != type) continue;
                q.add(new Point(nx, ny));
                visit[nx][ny] = true;
                // (x,y)를 (0,0)로 변환했기 때문에 (nx,ny) -> (nx-x,ny-y)로 변환됨
                res.add(new Point(nx - x, ny - y));
            }
        }
        // table의 블록이나 game_board의 빈칸의 좌표를 소팅함
        Collections.sort(res, (p1, p2) -> {
            if(p1.x == p2.x) return p1.y - p2.y;
            return p1.x - p2.x;
        });
        return res;
    }

    public boolean fit(List<Point> board, List<Point> block) {
        // 4번 90도 회전
        for(int k = 0; k < 4; k++) {
            // 모든 점을 (0,0)을 기준으로 변환
            int zeroX = block.get(0).x;
            int zeroY = block.get(0).y;
            for(int i = 0; i < block.size(); i++) {
                block.get(i).x -= zeroX;
                block.get(i).y -= zeroY;
            }

            boolean same = true;
            for(int i = 0; i < block.size(); i++) {
                if(board.get(i).x == block.get(i).x && board.get(i).y == block.get(i).y) continue;
                same = false;
                break;
            }
            if(same) return true;

            // 원점 기준 90도 회전: (x,y) -> (y,-x)
            for(int i = 0; i < block.size(); i++) {
                int tmp = block.get(i).x;
                block.get(i).x = block.get(i).y;
                block.get(i).y = -tmp;
            }
            // 소팅
            Collections.sort(block, (p1, p2) -> {
                if(p1.x == p2.x) return p1.y - p2.y;
                return p1.x - p2.x;
            });
        }
        return false;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}