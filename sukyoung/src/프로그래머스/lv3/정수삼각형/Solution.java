package 프로그래머스.lv3.정수삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        for(int i=1; i<triangle.length; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
        }
        for(int i=2; i<triangle.length; i++){
            for(int j=1; j<i; j++)
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
        }

        for(int i=0; i<triangle[triangle.length-1].length; i++){
            answer = Math.max(dp[triangle.length-1][i], answer);
        }

        return answer;
    }
}