package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no6118 {
    public static int maxDistance, number, count;
    public static boolean[] visit;
    public static LinkedList<Integer>[] placeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        placeList = new LinkedList[n+1];
        for(int i=0; i<n+1; i++)
            placeList[i] = new LinkedList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            placeList[node1].add(node2);
            placeList[node2].add(node1);
        }

        visit = new boolean[n+1];
        number = 2; maxDistance = -1; count = 1;

        findPlace();
        System.out.print(number+" "+maxDistance+" "+count);
    }
    public static void findPlace(){
        Queue<place> queue = new LinkedList<>();
        queue.add(new place(1, 0));
        visit[1] = true;

        while(!queue.isEmpty()){
            place now = queue.poll();

            if(maxDistance < now.cnt){
                maxDistance = now.cnt;
                number = now.num;
                count = 1;
            }else if(maxDistance == now.cnt){
                count ++;

                if(number > now.num)
                    number = now.num;
            }

            for(int i=0; i<placeList[now.num].size(); i++){
                int next = placeList[now.num].get(i);

                if(visit[next])
                    continue;

                visit[next] = true;
                queue.add(new place(next, now.cnt+1));
            }

        }
    }
}
class place{
    int num;
    int cnt;
    public place(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }
}
