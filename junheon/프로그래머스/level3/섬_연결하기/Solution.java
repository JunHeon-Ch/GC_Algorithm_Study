package 프로그래머스.level3.섬_연결하기;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42861#
 * 알고리즘: Kruskal, union find
 * 시간복잡도: O(ElogE + V*E), ElogE -> 정렬 시간, V*E -> 모든 엣지 확인 => O(ElongE)
            E=((V-1)*V)/2(costs 배열의 길이), V=100(섬 개수)
 */

class Solution {

    int[] parent;

    public int solution(int n, int[][] costs) {
        // cost 기준으로 sorting
        // 시간복잡도: O(ElogE)
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        parent = new int[n]; // union find를 사용하기 위한 배열
        for(int i = 0; i < n; i++) {
            parent[i] = i; // 초기 자기 자신을 부모로 설정
        }

        int answer = 0;
        // 시간복잡도: O(V*E), V = union find 시간, E는 전체 edge 확인 시간
        for(int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];

            int fromParent = unionFind(from);
            int toParent = unionFind(to);
            if(fromParent == toParent) continue;
            parent[toParent] = fromParent;
            answer += cost;
        }
        return answer;
    }

    // 최상위 부모 노드 찾기
    public int unionFind(int v) {
        if(parent[v] == v) return v;
        return parent[v] = unionFind(parent[v]);
    }
}