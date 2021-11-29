rpackage 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no1197 {
    public static int v,e;
    public static LinkedList<node>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        adjList = new LinkedList[v+1];
        for(int i=1; i<=v; i++)
            adjList[i] = new LinkedList<>();

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjList[node1].add(new node(node2, value));
            adjList[node2].add(new node(node1, value));

        }
        System.out.print(graph());
    }
    public static long graph(){
        boolean[] visit = new boolean[v+1];
        PriorityQueue<node> queue = new PriorityQueue<>();
        queue.add(new node(1, 0));

        long result = 0;
        int cnt = 0;
        while(!queue.isEmpty()){
            node now = queue.poll();

            if(visit[now.end])
                continue;
            result += now.value;
            visit[now.end] = true;
            cnt++;

            if(cnt == v)
                return result;

            for(int i=0; i<adjList[now.end].size(); i++){
                node next = adjList[now.end].get(i);
                if(!visit[next.end]){
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
class node implements Comparable<node>{
    int end;
    int value;
    public node(int end, int value){
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(node o){
        return Integer.compare(this.value, o.value);
    }

}
