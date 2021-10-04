package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no2606 {
    public static boolean[] visit;
    public static LinkedList<Integer>[] computerList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        computerList = new LinkedList[v+1];
        for(int i=0; i<v+1; i++)
            computerList[i] = new LinkedList<>();

        for(int i=0; i<e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            computerList[node1].add(node2);
            computerList[node2].add(node1);
        }

        visit = new boolean[v+1];
        int answer = virus();
        System.out.print(answer);

    }
    public static int virus(){
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=0; i<computerList[now].size(); i++){
                int next = computerList[now].get(i);

                if(visit[next])
                    continue;

                visit[next] = true;
                queue.add(next);
                cnt++;
            }
        }
        return cnt;
    }
}
