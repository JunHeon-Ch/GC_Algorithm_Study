package 프로그래머스.level3.N으로_표현;

class Solution {

    int ans = -1;

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return ans;
    }

    private void dfs(int N, int num, int cnt, int res) {
        if(cnt > 8) return;
        if(res == num) {
            if(ans == -1 || ans > cnt) {
                ans = cnt;
                return;
            }
        }

        int n = 0;
        for(int i = 0; i < 8; i++) {
            n = n * 10 + N;
            dfs(N, num, cnt + i + 1, res + n);
            dfs(N, num, cnt + i + 1, res - n);
            dfs(N, num, cnt + i + 1, res * n);
            dfs(N, num, cnt + i + 1, res / n);
        }
    }
}