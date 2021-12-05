package 프로그래머스.level3.순위;

/*
https://programmers.co.kr/learn/courses/30/lessons/49191#
 * 알고리즘: 플로이드-워셜
 * 플로이드-워셜 설명 -> https://blog.naver.com/ndb796/221234427842
 * 플로이드-워셜은 거쳐가는 정점을 기준으로 모든 정점에서 모든 정점으로의 최단 거리를 알 수 있는 알고리즘이다.
 * 플로이드-워셜 -> DP

 * 시간복잡도: O(n^3), n=100

 * 이 문제는 경기를 치뤘는지 확인하는 문제이기 때문에 boolean 타입 배열을 사용해도 무방함.
 * 하지만 순위를 반환해야 하는 문제가 있을 경우 int 배열을 사용해서 이기고 지고를 명확하게 적어줘야 함.
 */

class Solution {
    public int solution(int n, int[][] results) {
        // w -> l = 1 / l -> w = -1
        int[][] game = new int[n][n];
        for(int[] r : results) {
            int w = r[0] - 1;
            int l = r[1] - 1;
            game[w][l] = 1;
            game[l][w] = -1;
        }

        // 플로이드-워셜
        // k -> 거쳐가는 노드
        for(int k = 0; k < n; k++) {
            // i -> 출발 노드
            for(int i = 0; i < n; i++) {
                // j -> 도착 노드
                for(int j = 0; j < n; j++) {
                    // i > k > j
                    if(game[i][k] == 1 && game[k][j] == 1) {
                        game[i][j] = 1;
                        game[j][i] = -1;
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            int j;
            for(j = 0; j < n; j++) {
                if(i == j) continue;
                if(game[i][j] == 0) break;
            }
            if(j == n) ans++;
        }
        return ans;
    }
}