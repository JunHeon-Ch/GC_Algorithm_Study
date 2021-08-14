package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1697 {
    public static int n;
    public static int k;
    public static int[] walk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        walk = new int[100001];

        if(n == k)
            System.out.println(0);
        else
            bfs();
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        walk[n] = 1;

        while(!queue.isEmpty()){
            int dot = queue.poll();

            for(int i=0; i<3; i++){
                int next;

                if (i == 0) {
                    next = dot + 1;
                } else if (i == 1) {
                    next = dot - 1;
                } else {
                    next = dot * 2;
                }

                if(next == k) {
                    System.out.println(walk[dot]);
                    return;
                }

                if (next >= 0 && next < walk.length && walk[next] == 0) {
                    queue.add(next);
                    walk[next] = walk[dot] + 1;
                }
            }
        }
    }
}
