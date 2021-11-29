package 프로그래머스.lv2.배달;

import java.util.*;

class Solution {
    public int[] distance;
    public LinkedList<delivery>[] country;
    public int solution(int N, int[][] road, int K) {

        country = new LinkedList[N+1];
        for(int i=1; i<=N; i++)
            country[i] = new LinkedList<>();

        for(int i=0; i<road.length; i++){
            country[road[i][0]].add(new delivery(road[i][1], road[i][2]));
            country[road[i][1]].add(new delivery(road[i][0], road[i][2]));
        }

        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        bfs(K);

        int answer = 0;
        for(int d : distance){
            if(d <= K) answer++;
        }

        return answer;
    }
    public void bfs(int K){
        PriorityQueue<delivery> queue = new PriorityQueue<>();
        queue.add(new delivery(1, 0));
        distance[1] = 0;

        while(!queue.isEmpty()){
            delivery now = queue.poll();

            for(int i=0; i<country[now.to].size(); i++){
                delivery next = country[now.to].get(i);

                if(distance[next.to] > distance[now.to] + next.cost){
                    distance[next.to] = distance[now.to] + next.cost;
                    queue.offer(new delivery(next.to, distance[next.to]));
                }
            }
        }
    }
}
class delivery implements Comparable<delivery>{
    int to;
    int cost;
    public delivery(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(delivery o){
        return cost - o.cost;
    }
}