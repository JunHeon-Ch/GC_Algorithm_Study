package problem_week3;

import java.util.Scanner;

public class Problem_10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		final int mod = 1000000000;
		long sum = 0;
		
		int N = sc.nextInt();
		long[][] d = new long[N+1][10];
		for(int i=1; i<=9; i++) d[1][i]=1;
		for(int i=2; i<=N; i++)
		{
			for(int j=0; j<10; j++)
			{
				if(j==0) d[i][j]=d[i-1][j+1];
				else if(j==9) d[i][j]=d[i-1][j-1];
				else d[i][j]=d[i-1][j+1]+d[i-1][j-1];
				d[i][j] %= mod;
			}
		}
		for(int i=0; i<10; i++) sum+=d[N][i];
		System.out.println(sum%mod);
	}
}