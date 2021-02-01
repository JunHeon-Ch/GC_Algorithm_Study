package problem_week6; 

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem_1261 {
	
	public static int M, N;
	public static int[][] maze;
	public static int[][] cost;
	public static boolean[][] check;
	public static int[] dx= {0, 1, 0, -1};
	public static int[] dy= {1, 0, -1, -0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		maze=new int[N][M];
		cost=new int[N][M];
		check=new boolean[N][M];
		
		for(int i=0; i<N; i++)
		{
			String line = sc.next();
			for(int j=0; j<M; j++) maze[i][j]=line.charAt(j)-'0';
		}
		
		Deque<Point> q=new LinkedList<>();
		q.addLast(new Point(0,0));
		check[0][0]=true;
		
		while(!q.isEmpty()){
			
			Point now = q.pollLast();
			int x = now.x;
			int y = now.y;
			
			for(int i=0; i<4; i++)
			{
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=M||check[nx][ny]) continue;
				if(maze[nx][ny]==0)
				{
					cost[nx][ny]=cost[x][y];
					q.addLast(new Point(nx, ny));
				}
				else
				{
					cost[nx][ny]=cost[x][y]+1;
					q.addFirst(new Point(nx, ny));
				}
				check[nx][ny]=true;
			}
		}
		
		System.out.println(cost[N-1][M-1]);
	}
}