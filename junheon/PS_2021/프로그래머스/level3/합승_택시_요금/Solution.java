package PS_2021.프로그래머스.level3.합승_택시_요금;

/*
https://programmers.co.kr/learn/courses/30/lessons/72413?language=java
 * 알고리즘: 플로이드-와샬(DP)
 * 시간복잡도: O(n^3), n=200(지점 갯수)
 */

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] cost = new int[n + 1][n + 1]; // i -> j 최소 비용 저장
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) cost[i][j] = 0;
                else cost[i][j] = -1; // 길이 없는 경우
            }
        }
        for(int[] f : fares) {
            cost[f[0]][f[1]] = f[2];
            cost[f[1]][f[0]] = f[2];
        }

        // i -> j로 가는 경로 중 k를 거쳐 가는 경로가 최소 비용일 때 수정
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(cost[i][k] == -1 || cost[k][j] == -1) continue;
                    if(cost[i][j] == -1 || cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        // s -> i: A, B 같이 가는 경로
        // i -> a, i -> b: A, B 따로 가는 경로
        for(int i = 1; i <= n; i++) {
            if(cost[a][i] != -1 && cost[b][i] != -1 && cost[s][i] != -1) {
                answer = Math.min(answer, cost[a][i] + cost[b][i] + cost[s][i]);
            }
        }
        return answer;
    }
}