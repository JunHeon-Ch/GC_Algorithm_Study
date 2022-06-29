package PS_2021.프로그래머스.level3.모두_0으로_만들기;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/76503
 * 알고리즘: DFS + 트리
 * 시간복잡도: O(V*E), V=300,000(a 배열 길이), E=V-1(edges 배열의 길이)
 -> 효율성이 없는 문제라 가능한듯..
 * comment
 * 트리의 연결 정보를 저장할 땐 연결 리스트를 사용하자
 */

class Solution {

    long ans = 0; // 횟수
    long[] num; // 각 점의 가중치
    List<Integer>[] conn; // 연결 정보
    boolean[] v; // 방문 여부

    public long solution(int[] a, int[][] edges) {
        // 초기화
        int n = a.length;
        num = new long[n];
        conn = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            num[i] = a[i];
            conn[i] = new ArrayList<>();
        }
        // 연결 정보 저장
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            conn[u].add(v);
            conn[v].add(u);
        }

        v = new boolean[n];
        dfs(0);
        return ans;
    }

    public void dfs(int idx) {
        v[idx] = true;
        for(int i = 0; i < conn[idx].size(); i++) {
            int next = conn[idx].get(i);
            if(v[next]) continue;
            dfs(next);
            num[idx] += num[next];
        }
        ans += Math.abs(num[idx]);
    }

//    런타임 에러 -> why? 자바라서 그렇다나 뭐라나.. 시발거
//
//    public void dfs(int idx) {
//        v[idx] = true;
//        for(int i : conn[idx]) {
//            if(v[i]) continue;
//            dfs(i);
//            num[idx] += num[i];
//        }
//        ans += Math.abs(num[idx]);
//    }
}