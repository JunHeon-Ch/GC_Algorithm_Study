package problem_week6;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2178 {
	
	public static int N;
	public static int M;
	public static int[][] maze;
	public static int[][] cost;
	public static boolean[][] check;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N][M];
		cost = new int[N][M];
		check = new boolean[N][M];
		
		for(int i=0; i<N; i++)
		{	
			String line = sc.next();
			for(int j=0; j<M; j++) maze[i][j]=Character.getNumericValue(line.charAt(j));
		}
		
		BFS(0, 0);
		System.out.print(cost[N-1][M-1]);
	}
	
	public static void BFS(int i, int j)
	{
		Queue<Point> q = new LinkedList<>();
		
		check[i][j] = true;
		cost[i][j] = 1;
		q.add(new Point(i, j));
		
		while(!q.isEmpty())
		{	
			Point p = q.peek();
			q.remove();

			for(int k=0; k<4; k++)
			{	
				int nx = p.x+dx[k];
				int ny = p.y+dy[k];
				
				if(nx>=0&&ny>=0&&nx<N&&ny<M)
				{	
					if(check[nx][ny]==false&&maze[nx][ny]==1)
					{
						check[nx][ny] = true;
						cost[nx][ny] = cost[p.x][p.y] + 1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}
}
