package 프로그래머스.lv3.합승택시요금;

import java.util.*;

class Solution {
    public int MAX = 20000001;
    public LinkedList<taxi>[] list;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        list = new LinkedList[n+1];
        for(int i=0; i<=n; i++)
            list[i] = new LinkedList<taxi>();

        for(int i=0; i<fares.length; i++){
            int node1 = fares[i][0];
            int node2 = fares[i][1];

            list[node1].add(new taxi(node2, fares[i][2]));
            list[node2].add(new taxi(node1, fares[i][2]));
        }

        //최소거리는 (S -> 합승) + (합승 -> A) + (합승 -> B) 중 최소값
        int[] fromS = dijkstra(n, s);
        int[] toA = dijkstra(n, a);
        int[] toB = dijkstra(n, b);

        for (int i = 1; i < n + 1; i++)
            answer = Math.min(answer, fromS[i] + toA[i] + toB[i]);

        return answer;
    }

    public int[] dijkstra(int n, int start){
        int[] costs = new int[n+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        PriorityQueue<taxi> queue = new PriorityQueue<>();
        queue.add(new taxi(start, 0));
        costs[start] = 0;

        while (!queue.isEmpty()) {
            taxi now = queue.poll();

            if (costs[now.node] < now.cost)
                continue;

            for(int i=0; i<list[now.node].size(); i++) {
                taxi temp = list[now.node].get(i);
                int newCost = costs[now.node] + temp.cost;

                if (newCost < costs[temp.node]){
                    costs[temp.node] = newCost;
                    queue.add(new taxi(temp.node, newCost));
                }
            }
        }
        return costs;
    }
}

class taxi implements Comparable<taxi>{
    int node;
    int cost;

    public taxi (int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(taxi t){
        return this.cost - t.cost;
    }
}