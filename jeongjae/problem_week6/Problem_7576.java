package problem_week6;

import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_7576 {
	
	public static int M;
	public static int N;
	public static int tomato[][];
	public static boolean ripe[][];
	public static int day[][];
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	public static int max = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		tomato = new int[N][M];
		ripe = new boolean[N][M];
		day = new int[N][M];
		Queue<Point> q = new LinkedList<>(); 
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				tomato[i][j] = sc.nextInt();
				if(tomato[i][j]==1)
				{
					ripe[i][j] = true;
					q.add(new Point(i, j));
				}
				else if(tomato[i][j]==-1) ripe[i][j] = true;
			}
		}
		
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
					if(ripe[nx][ny]==false&&tomato[nx][ny]==0)
					{
						ripe[nx][ny] = true;
						day[nx][ny] = day[p.x][p.y] + 1;
						if(day[nx][ny]>max) max = day[nx][ny];
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				if(ripe[i][j]==false)
				{
					System.out.print(-1);
					return;
				}
			}
		}
		if(max==0)
		{
			System.out.print(0);
			return;
		}
		else
		{
			System.out.print(max);
			return;
		}
	}	
}