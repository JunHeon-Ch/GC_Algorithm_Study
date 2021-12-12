package 프로그래머스.level3.GPS;

/*
https://programmers.co.kr/learn/courses/30/lessons/1837
 * 알고리즘: DP
 * D(i, j) = i 노드에 j번째 왔을 때 최소 오류 수정 횟수
 * D[i][j] = min(d[k][j-1]),
 * 0 <= k < n(노드 개수), 0 < j < l(택시가 시간대별로 보내오는 거점 정보의 총 개수)
 * 시간복잡도: O(m*n^2), n=200(노드 개수), m=100(택시가 시간대별로 보내오는 거점 정보의 총 개수)
 */

class Solution {

    public int solution(int n, int m, int[][] edge_list, int l, int[] gps_log) {
        // 도로 정보
        boolean[][] road = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            road[i][i] = true;
        }
        for(int i = 0; i < m; i++) {
            int u = edge_list[i][0] - 1;
            int v = edge_list[i][1] - 1;
            road[u][v] = road[v][u] = true;
        }

        int[][] d = new int[n][l];
        for(int i = 0; i < n; i++) {
            // 승차 위치 0으로 세팅
            // 승차 위치와 하차 위치는 오류가 없음
            // -> 승차 위치를 제외한 나머지 노드는 최대값으로 세팅
            for(int j = 0; j < l; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
            if(gps_log[0] - 1 == i) d[i][0] = 0;
        }

        // D[i][j] = min(D[k][j-1]), 0 <= k < n, 0 < j < l
        for(int j = 1; j < l; j++) {
            for(int i = 0; i < n; i++) {
                for(int k = 0; k < n; k++) {
                    if(!road[i][k]) continue;
                    d[i][j] = Math.min(d[i][j], d[k][j - 1]);
                }
                // j번째 gps 기록이 i 노드가 아닌 경우 오류
                if(d[i][j] != Integer.MAX_VALUE && gps_log[j] - 1 != i) d[i][j]++;
            }
        }
        return d[gps_log[l - 1] - 1][l - 1] != Integer.MAX_VALUE ? d[gps_log[l - 1] - 1][l - 1] : -1;
    }
}