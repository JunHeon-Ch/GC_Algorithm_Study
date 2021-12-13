package 프로그래머스.lv3.타일링;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++){
            if(i <= 2)
                dp[i] = i;
            else
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
