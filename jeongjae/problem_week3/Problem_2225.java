package problem_week3;

import java.util.Scanner;

public class Problem_2225 {
	
	final static int mod = 1000000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] d = new long[K+1][N+1];
		d[0][0]=1;
		for(int i=1; i<=K; i++)
		{
			for(int j=0; j<=N; j++)
			{
				for(int l=0; l<=j; l++)
				{
					d[i][j] += d[i-1][j-l];
					d[i][j] %= mod;
				}
			}
		}
		System.out.print(d[K][N]);
	}
}