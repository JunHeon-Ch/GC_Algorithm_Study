package problem_week4;

import java.util.Scanner;

public class Problem_1309 {
	
	public static final int mod = 9901;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//d[i][j] : i번째 행까지 사자를 배치하는데 마지막 사자의 위치가 j인 경우의 수
		int[][] d = new int[N+1][3];
		d[1][0] = d[1][1] = d[1][2] = 1;
		
		for(int i=2; i<=N; i++)
		{
			d[i][0]=(d[i-1][0]+d[i-1][1]+d[i-1][2])%mod;
			d[i][1]=(d[i-1][0]+d[i-1][2])%mod;
			d[i][2]=(d[i-1][0]+d[i-1][1])%mod;
		}
		
		System.out.print((d[N][0]+d[N][1]+d[N][2])%mod);
	}
}