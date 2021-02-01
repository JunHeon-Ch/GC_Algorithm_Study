package problem_week6;

import java.io.InputStreamReader;
import java.awt.Point;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_16947 {
    
	public static ArrayList<Integer>[] map;
    public static int N;
    public static boolean[] c;

    public static void main(String[] args) throws Exception{
    	// TODO Auto-generated method stub
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++) map[i] = new ArrayList<>();
        c = new boolean[N+1];
        int[] ans = new int[N+1];

        for(int i=0; i<N; i++)
        {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            map[start].add(end);
            map[end].add(start);
        }

        for(int i=1; i<=N; i++)
        {
            if(isCycle(i, i, i)) break;
            else c = new boolean[N+1];
        }

        for(int i=1; i<=N; i++)
        {
            if(c[i]) continue;
            int count = BFS(i);
            ans[i] = count;
        }

        for(int i=1; i<=N; i++)
            System.out.print(ans[i]+" ");
    }

    public static boolean isCycle(int before, int v, int start) {
        c[v] = true;

        for(int i=0; i<map[v].size(); i++) {
            int e = map[v].get(i);

            if(!c[e]) {
                if(isCycle(v, e, start))
                    return true;
            }

            else if(e!=before && e==start)
                return true;
        }
        c[v] = false;

        return false;
    }

    public static int BFS(int v)
    {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        
        queue.add(new Point(v, 0));
        visited[v] = true;

        while(!queue.isEmpty())
        {
            Point temp = queue.peek();
            queue.remove();
            
            if(c[temp.x]) return temp.y;

            for(int i=0; i<map[temp.x].size(); i++)
            {
                int e = map[temp.x].get(i);
                if(!visited[e])
                {
                    visited[e] = true;
                    queue.add(new Point(e, temp.y+1));
                }
            }
        }
        return 0;
    }
}