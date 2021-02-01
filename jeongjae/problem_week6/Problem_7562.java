package problem_week6;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_7562 {
	
	public static int T;
	public static int l;
	public static int[][] chess;
	public static boolean[][] check;
	public static int[][] cost;
 	public static Queue<Point> q = new LinkedList<>();
	public static int[] dx = {-2, -2, -1, -1, 2, 2, 1, 1};
	public static int[] dy = {-1, 1, -2, 2, -1, 1, -2, 2};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int i=0; i<T; i++)
		{
			l = sc.nextInt();
			chess = new int[l][l];
			check = new boolean[l][l];
			cost = new int[l][l];
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			check[x][y] = true;
			q.add(new Point(x, y));
			
			while(!q.isEmpty())
			{
				Point p = q.peek();
				q.remove();
				
				for(int j=0; j<8; j++)
				{
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					
					if(nx>=0&&ny>=0&&nx<l&&ny<l&&check[nx][ny]==false)
					{
						check[nx][ny] = true;
						cost[nx][ny] = cost[p.x][p.y] + 1;
						q.add(new Point(nx, ny));
					}
				}
			}
			
			int nx = sc.nextInt();
			int ny = sc.nextInt();
			System.out.println(cost[nx][ny]);
		}
	}
}