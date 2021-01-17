package problem_week4;

import java.util.Scanner;

public class Problem_3085 {
	
	public static int N;
	public static char[][] board;
	public static int max;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		board = new char[N][N];
		max = 0;
		
		for(int i=0; i<N; i++) board[i]=sc.next().toCharArray();
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N-1; j++)
			{
				char temp = board[i][j];
				board[i][j]=board[i][j+1];
				board[i][j+1]=temp;
				checkboard();
				temp=board[i][j];
				board[i][j]=board[i][j+1];
				board[i][j+1]=temp;
			}
		}
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N-1; j++)
			{
				char temp = board[j][i];
				board[j][i]=board[j+1][i];
				board[j+1][i]=temp;
				checkboard();
				temp=board[j][i];
				board[j][i]=board[j+1][i];
				board[j+1][i]=temp;
			}
		}
		System.out.print(max);
	}
	
	public static void checkboard()
	{
		for(int i=0; i<N; i++)
		{
			int count = 1;
			for(int j=0; j<N-1; j++)
			{
				if(board[i][j]==board[i][j+1]) count=count+1;
				else count = 1;
				if(count>max) max = count;
			}
		}
		
		for(int i=0; i<N; i++)
		{	
			int count = 1;
			for(int j=0; j<N-1; j++)
			{
				if(board[j][i]==board[j+1][i]) count=count+1;
				else count=1;
				if(count>max) max = count;
			}
		}
	}

}
