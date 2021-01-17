package problem_week4;

import java.util.Scanner;
//참고 블로그 https://hyeooona825.tistory.com/60
public class Problem_14500 {
	public static int N;
	public static int M;
	public static int[][] paper, visited;
	public static int max;
	public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		max = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		paper = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++) paper[i][j]=sc.nextInt();
		}
		
		for(int i=0; i<N*M; i++)
		{
			int x = i/M;
			int y = i%M;
			visited[x][y]=1;
			visit(x, y, 1, paper[x][y]);
			Calculate(x,y);
			visited[x][y]=0;
		}
		System.out.print(max);
	}
	
	public static void visit(int x, int y, int count, int sum)
	{
		if(count==4)
		{
			max=Math.max(max,sum);
			return;
		}
		
		for(int i=0; i<4; i++)
		{
			int sx = x + dx[i];
			int sy = y + dy[i];
			if(sx>=0&&sx<N&&sy>=0&&sy<M&&visited[sx][sy]==0)
			{
				visited[sx][sy]=1;
				visit(sx, sy, count+1, sum+paper[sx][sy]);
				visited[sx][sy]=0;
			}
		}
	}
	
	public static void Calculate(int x, int y)
	{
		for(int i=0; i<4; i++)
		{
			int sum = paper[x][y];
			boolean flag = true;
			
			for(int j=0; j<3; j++)
			{
				int sx = x + dx[(i+j)%4];
				int sy = y + dy[(i+j)%4];
				
				if(sx>=0&&sx<N&&sy>=0&&sy<M) sum+=paper[sx][sy];
				else
				{
					flag = false;
					break;
				}
			}
			if(flag==true) max = Math.max(max, sum);
		}
	}
}