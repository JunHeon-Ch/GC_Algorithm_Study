//package PS_2021.카카오_공채_2021;
//
//class Solution {
//
//    boolean[][] avis, bvis;
//    int[] dx = {-1, 1, 0, 0};
//    int[] dy = {0, 0, -1, 1};
//    int ans = Integer.MIN_VALUE;
//
//    public int solution(int[][] board, int[] aloc, int[] bloc) {
//        int n = board.length;
//        int m = board[0].length;
//
//        avis = new boolean[n][m];
//        bvis = new boolean[n][m];
//
//        solve(board, n, m, aloc[0], aloc[1], bloc[0], bloc[1], 0, 0);
//        int answer = -1;
//        return answer;
//    }
//
//    private void solve(int[][] board, int n, int m, int ax, int ay, int bx, int by, int anp, int bnp, int acnt, int bcnt) {
//        if(anp == 1 && bnp == 0) {
//            ans = Math.max(ans, acnt + bcnt);
//            return;
//        }
//        for(int i = 0; i < 4; i++) {
//            int nax = ax + dx[i];
//            int nay = ay + dy[i];
//            if(check(nax, nay, n, m)) continue;
//            if(board[nax][nay] == 0 || avis[nax][nay]) continue;
//            if(nax == bx && nay == by) continue;
//            avis[nax][nay] = true;
//            board[ax][ay] = 0;
//            int j;
//            for(j = 0; j < 4; j++) {
//                int nbx = bx + dx[i];
//                int nby = by + dy[i];
//                if(check(nbx, nby, n, m) || board[nbx][nby] == 0) continue;
//            }
//            if(j == 4) {
//                solve(board, n, m, )
//            }
//
//            for(j = 0; j < 4; j++) {
//                int nbx = bx + dx[i];
//                int nby = by + dy[i];
//                if(check(nbx, nby, n, m)) continue;
//                if(board[nax][nay] == 0 || avis[nax][nay]) continue;
//                avis[nax][nay] = true;
//                board[ax][ay] = 0;
//            }
//        }
//    }
//
//    private boolean check(int x, int y, int n, int m) {
//        return x < 0 || x >= n || y < 0 || y >= m;
//    }
//}