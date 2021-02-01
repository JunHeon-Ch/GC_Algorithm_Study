package problem_week6;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1967 {

	public static ArrayList<Point>[] graph;
	public static boolean[] check;
	public static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		graph = new ArrayList[N+1];
		check = new boolean[N+1];
		
		for(int i=1; i<=N; i++) graph[i] = new ArrayList<Point>();

		for(int i=0; i<N-1; i++)
		{
			int n = sc.nextInt();
			int child = sc.nextInt();
			int weight = sc.nextInt();
			graph[n].add(new Point(child, weight));
			graph[child].add(new Point(n, weight));
		}
		
		
		int max = BFS(1).x;
		check = new boolean[N+1];
		int ans = BFS(max).y;

		System.out.print(ans);
	}

	public static Point BFS(int start) {

		int max = 0;
		int n = 0;
		
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(start, 0));
		check[start] = true;

		while(!q.isEmpty())
		{
			Point p = q.poll();

			for (int i=0; i<graph[p.x].size(); i++)
			{
				Point np = graph[p.x].get(i);

				if (!check[np.x])
				{
					int nw = p.y + np.y;

					q.add(new Point(np.x, nw));
					if (max<nw)
					{
						max = nw;
						n = np.x;
					}
					check[np.x] = true;
				}
			}
		}
		
		return new Point(n, max);
	}
}