package PS_2021.라인_인턴십_2021.Problem4;

/*
 * 알고리즘: 완전탐색
 * 최대 구매할 수 있는 로봇의 개수가 15이기 때문에 완전탐색으로 가능
 * 시간복잡도: O((2^n)*m), n=15(needs의 가로 길이), m=1000(needs의 세로 길이)
 */

class Solution {

    int[] buy;
    int ans = 0;

    public int solution(int[][] needs, int r) {
        buy = new int[needs[0].length];
        solve(needs, 0, 0, r, needs[0].length);
        return ans;
    }

    public void solve(int[][] needs, int index, int selected, int r, int n) {
        if(selected == r) {
            int cnt = 0;
            for(int i = 0; i < needs.length; i++) {
                boolean flag = true;
                for(int j = 0; j < buy.length; j++) {
                    if(needs[i][j] == 1 && buy[j] == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            ans = Math.max(ans, cnt);
            return;
        }
        if(index >= n) return;
        buy[index] = 1;
        solve(needs, index + 1, selected + 1, r, n);
        buy[index] = 0;
        solve(needs, index + 1, selected, r, n);
    }
}