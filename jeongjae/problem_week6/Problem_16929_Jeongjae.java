package problem_week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_16929_Jeongjae {
	
	public static int N;
	public static int M;
	public static char[][] board;
	public static boolean[][] check;
	public static int[][] count;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	public static String ans = "No";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		board = new char[N][M];
		check = new boolean[N][M];
		count = new int[N][M];
		
		for(int i=0; i<N; i++)
		{	
			String line = br.readLine();
			for(int j=0; j<M; j++)
			{
				board[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				if(check[i][j]==false)
				{	
					DFS(i, j, 1);
					if(ans.equals("Yes"))
					{
						System.out.println("Yes");
						return;
					}
				}
			}
		}
		System.out.println("No");
	}
	
	public static void DFS(int i, int j, int c)
	{	
		check[i][j]=true;
		count[i][j]=c;
		
		for(int k=0; k<4; k++)
		{
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx>=0&&ny>=0&&nx<N&&ny<M&&board[nx][ny]==board[i][j]&&check[nx][ny]==false)
			{
				DFS(nx, ny, c+1);
			}
			if(nx>=0&&ny>=0&&nx<N&&ny<M&&board[nx][ny]==board[i][j]&&check[nx][ny]==true)
			{
				if(c+1-count[nx][ny]>=4) ans = "Yes";
			}
		}
	}
}