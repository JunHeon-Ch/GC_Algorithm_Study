package 프로그래머스.lv3.가장먼노드;

import java.util.*;

class Solution {
    public LinkedList<Integer>[] adjList;
    public boolean[] visit;
    public int solution(int n, int[][] edge) {
        int answer = 0;

        adjList = new LinkedList[n+1];
        visit = new boolean[n+1];
        for(int i=1; i<=n; i++){
            adjList[i] = new LinkedList<Integer>();
        }

        for(int i=0; i<edge.length; i++){
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(adjList[i]);
        }
        //System.out.println(adjList[1].get(0));
        answer = bfs(1, n);

        return answer;
    }
    public int bfs(int start, int n){
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(start);

        int size = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                int node = queue.poll();
                for(int j=0; j<adjList[node].size(); j++){
                    if(!visit[adjList[node].get(j)]){
                        //System.out.println(adjList[node].get(j));
                        queue.add(adjList[node].get(j));
                        visit[adjList[node].get(j)] = true;
                    }
                }

            }
            size = queueSize;
        }
        return size;
    }
}
