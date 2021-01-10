package problem_week3;

import java.util.Scanner;

public class Problem_15988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		final int mod = 1000000009;
		int T = sc.nextInt();
		for(int i=0; i<T; i++)
		{
			int n = sc.nextInt();
			long[] d = new long[n+3];
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			for(int j=4; j<=n; j++) d[j] = (d[j-1]+d[j-2]+d[j-3])%mod;
			System.out.println(d[n]);
		}
	}
}