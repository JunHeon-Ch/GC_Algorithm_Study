package 프로그래머스.lv3.등굣길;

class Solution {

    public int solution(int m, int n, int[][] puddles) {

        int[][] map = new int[n+1][m+1];
        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;
        }

        //점화식 map[i][j] = map[i-1][j] + map[i][j-1];
        //물웅덩이면 0
        map[1][1] = 1;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(map[i][j] == -1){
                    map[i][j] = 0;
                    continue;
                }
                if(map[i - 1][j] > 0)
                    map[i][j] += map[i - 1][j] % 1000000007;
                if(map[i][j - 1] > 0)
                    map[i][j] += map[i][j - 1] % 1000000007;
            }
        }

        return map[n][m] % 1000000007;
    }
}
