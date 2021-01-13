package problem_week3;

import java.util.Scanner;

public class Problem_15990 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long d[][] = new long[100001][4];
		final long mod = 1000000009;
		d[1][1]=d[2][2]=d[3][3]=d[3][1]=d[3][2]=1;
		
		for(int i=4; i<=100000; i++)
		{
			d[i][1]=(d[i-1][2]+d[i-1][3])%mod;
			d[i][2]=(d[i-2][1]+d[i-2][3])%mod;
			d[i][3]=(d[i-3][1]+d[i-3][2])%mod;
		}
		int T = sc.nextInt();
		for(int i=0; i<T; i++)
		{
			int n = sc.nextInt();
			System.out.println((d[n][1]+d[n][2]+d[n][3])%mod);
		}
	}
}