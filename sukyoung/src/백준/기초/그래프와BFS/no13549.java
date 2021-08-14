package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no13549 {
    public static int[] seek = new int[100001];
    public static int n;
    public static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();

    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        Arrays.fill(seek, -1);
        seek[n] = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == k){
                System.out.println(seek[now]);
                return;
            }
            for(int i=0; i<3; i++) {
                int next;
                if(i == 0)
                    next = now * 2;
                else if(i == 1)
                    next = now - 1;
                else
                    next = now + 1;

                if(0 <= next && next <= 100000) {
                    if(seek[next] == -1) {
                        queue.add(next);
                        if(i == 0)
                            seek[next] = seek[now];
                        else
                            seek[next] = seek[now] + 1;
                    }
                }
            }
        }
    }
}
