package PS_2021.데브매칭_실리콘밸리_2021.Problem1;

class Solution {
    public int[] solution(int rows, int columns, int[][] connections, int[][] queries) {
        boolean[][][] map = new boolean[rows][columns][4];
        for (int i = 0; i < connections.length; i++) {
            int r1 = connections[i][0] - 1;
            int c1 = connections[i][1] - 1;
            int r2 = connections[i][2] - 1;
            int c2 = connections[i][3] - 1;
            if (r2 - r1 == 0) {
                if (c2 > c1) {
                    map[r1][c1][1] = true;
                    map[r2][c2][3] = true;
                } else {
                    map[r1][c1][3] = true;
                    map[r2][c2][1] = true;
                }
            } else if (c2 - c1 == 0) {
                if (r2 > r1) {
                    map[r1][c1][2] = true;
                    map[r2][c2][0] = true;
                } else {
                    map[r1][c1][0] = true;
                    map[r2][c2][2] = true;
                }
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r1 = Math.min(queries[i][0], queries[i][2]) - 1;
            int c1 = Math.min(queries[i][1], queries[i][3]) - 1;
            int r2 = Math.max(queries[i][0], queries[i][2]) - 1;
            int c2 = Math.max(queries[i][1], queries[i][3]) - 1;
            int res = 0;
            for (int c = c1; c <= c2; c++) {
                if(map[r1][c][0]) {
                    res++;
                    map[r1][c][0] = false;
                    if(r1 - 1 >= 0) {
                        map[r1 - 1][c][2] = false;
                    }
                }
                if(map[r2][c][2]) {
                    res++;
                    map[r2][c][2] = false;
                    if(r2 + 1 < rows) {
                        map[r2 + 1][c][0] = false;
                    }
                }
            }
            for(int r = r1; r <= r2; r++) {
                if(map[r][c1][3]) {
                    res++;
                    map[r][c1][3] = false;
                    if(c1 - 1 >= 0) {
                        map[r][c1 - 1][1] = false;
                    }
                }
                if(map[r][c2][1]) {
                    res++;
                    map[r][c2][1] = false;
                    if(c2 + 1 < columns) {
                        map[r][c2 + 1][3] = false;
                    }
                }
            }
            ans[i] = res;
        }
        return ans;
    }
}