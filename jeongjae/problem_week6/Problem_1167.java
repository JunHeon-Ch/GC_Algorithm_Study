package problem_week6;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Problem_1167 {
	
	public static int N;
	public static ArrayList<Point>[] tree;
	public static int[] cost;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        tree = new ArrayList[N+1];
        cost = new int[N+1];
        
        for(int i=0; i<=N; i++) tree[i] = new ArrayList<Point>();
 
        for(int i=0; i<N; i++)
        {
            int index = sc.nextInt();
            while(true)
            {
                int num = sc.nextInt();
                if(num==-1) break;
                int cost = sc.nextInt();
                tree[index].add(new Point(num, cost));
            }
        }
        
        cost = BFS(tree, 1, N);
        
        int start = 1;
        for(int i=2; i<=N; i++)
        {
        	if(cost[start]<cost[i]) start = i;
        }
        
        cost = BFS(tree, start, N);
        Arrays.sort(cost);
        System.out.println(cost[N]);
    }
    
    public static int[] BFS(ArrayList<Point>[] tree, int start, int N)
    {
        boolean [] check = new boolean[N+1];
        int [] cost = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;
 
        while(!q.isEmpty())
        {
            int v = q.poll();
            for(Point p : tree[v]) {
                int x = p.x;
                int y = p.y;
                if(!check[x])
                {
                    check[x] = true;
                    q.add(x);
                    cost[x] = cost[v] + y;
                }
            }
        }
        return cost;
    }
}