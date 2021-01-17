package problem_week4;

import java.util.Scanner;

public class Problem_11057 {
	
	public static final int mod = 10007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		//d[i][j] : i자리의 수 중 j로 끝나는 오르막 수
		int[][] d = new int[N+1][10];
		int sum = 0;
		
		for(int i=0; i<10; i++) d[1][i]=1;
		
		for(int i=2; i<=N; i++)
		{	
			for(int j=0; j<10; j++)
			{
				for(int k=0; k<j+1; k++)
				{
					d[i][j]+=(d[i-1][k])%mod;
				}
			}
		}
		
		for(int i=0; i<10; i++)
		{
			sum += d[N][i];
		}
		System.out.print(sum%mod);
	}
}