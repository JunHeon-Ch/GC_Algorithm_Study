package 프로그래머스.level2.삼각_달팽이;

class Solution {
    public int[] solution(int n) {
        int[][] mat = new int[n][n];
        int r = -1, c = 0, num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) r++;
                else if(i % 3 == 1) c++;
                else if(i % 3 == 2) {
                    r--; c--;
                }
                mat[r][c] = num++;
            }
        }

        int[] ans = new int[n * (n + 1) / 2];
        int k = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) break;
                ans[k++] = mat[i][j];
            }
        }
        return ans;
    }
}