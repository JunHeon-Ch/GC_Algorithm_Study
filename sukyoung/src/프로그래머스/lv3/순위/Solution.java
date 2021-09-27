package 프로그래머스.lv3.순위;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] resultList = new boolean[n][n];
        int answer = 0;
        for(int i=0; i<results.length; i++){
            int winner = results[i][0] - 1;
            int loser = results[i][1] - 1;
            resultList[winner][loser] = true;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(resultList[j][i] && resultList[i][k])
                        resultList[j][k] = true;
                }
            }
        }

        for(int i=0; i<n; i++){
            int result=0;
            for(int j=0; j<n; j++){
                if(resultList[i][j] || resultList[j][i])
                    result++;
            }
            if(result==n-1)
                answer++;
        }
        return answer;
    }
}
