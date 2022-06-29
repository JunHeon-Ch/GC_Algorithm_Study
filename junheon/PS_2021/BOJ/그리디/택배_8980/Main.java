package PS_2021.BOJ.그리디.택배_8980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        Queue<Box> load = new PriorityQueue<>((o1, o2) -> {
            if(o1.u == o2.u) return o1.v - o2.v;
            return o1.u - o2.u;
        });
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            load.add(new Box(u, v, w));
        }

        Queue<Box> unload = new PriorityQueue<>((o1, o2) -> o1.v - o2.v);
        int ans = 0;
        int cur = 0;
        for(int i = 1; i <= n; i++) {
            while(!unload.isEmpty() && unload.peek().v == i) {
                Box box = unload.poll();
//                System.out.println(box.u + " " + box.v + " " + box.w);
                cur -= box.w;
                ans += box.w;
//                System.out.println(cur);
            }
            while(!load.isEmpty() && load.peek().u == i) {
                Box box = load.poll();
                if(cur == c) continue;
                if(cur + box.w <= c) {
                    unload.add(box);
                    cur += box.w;
                }
                else {
                    unload.add(new Box(box.u, box.v, c - cur));
                    cur = c;
                }
            }
            System.out.println(i);
            for(Box box : unload) {
                System.out.println(box.u + " " + box.v + " " + box.w);
            }
            System.out.println();
        }
        System.out.println(ans);
    }

    static class Box {
        int u, v, w;

        public Box(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
