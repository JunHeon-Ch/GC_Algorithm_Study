package PS_2021.NH농협은행_공채_2022;

public class Solution2 {

    public int solution(int[][] positions) {
        int[][] seat = new int[101][101];
        for(int[] p : positions) {
            seat[p[0]][p[1]]++;
        }

        int ans = 0;
        for(int i = 0; i < seat.length; i++) {
            for(int j = 0; j < seat[i].length; j++) {
                if(seat[i][j] > 1) ans += seat[i][j] - 1;
            }
        }
        return ans;
    }
}
