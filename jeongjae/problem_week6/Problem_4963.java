package problem_week6;

import java.util.Scanner;

public class Problem_4963 {
	
	public static int island = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int w, h;
		int[][] map;
		boolean[][] check;
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		while((w=sc.nextInt())!=0)
		{
			h = sc.nextInt();
			map = new int[h][w];
			check = new boolean[h][w];
			
			for(int i=0; i<h; i++)
			{
				for(int j=0; j<w; j++) map[i][j]=sc.nextInt();
			}
			
			for(int i=0; i<h; i++)
			{
				for(int j=0; j<w; j++)
				{
					if(check[i][j]==false&&map[i][j]==1)
					{	
						island++;
						DFS(i, j, dx, dy, w, h, check, map);
					}
				}
			}
			
			System.out.println(island);
			island = 0;
		}
	}
	
	public static void DFS(int i, int j, int[] dx, int[] dy, int w, int h, boolean[][] check, int[][] map)
	{
		check[i][j] = true;
		
		for(int k=0; k<8; k++)
		{
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx>=0&&ny>=0&&nx<h&&ny<w&&check[nx][ny]==false&&map[nx][ny]==1)
			{	
				DFS(nx, ny, dx, dy, w, h, check, map);
			}
		}
	}
}