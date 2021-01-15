package problem_week4;

import java.util.Scanner;

public class Problem_9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++)
		{
			int n = sc.nextInt();
			int[][] s = new int[3][n+1];
			int[][] d = new int[3][n+1];
			
			for(int j=1; j<3; j++)
			{
				for(int k=1; k<n+1; k++) s[j][k] = sc.nextInt();
			}
			
			d[1][1]=s[1][1];
			d[2][1]=s[2][1];
			d[1][2]=d[2][1]+s[1][2];
			d[2][2]=d[1][1]+s[2][2];
			
			for(int k=3; k<=n; k++)
			{
				d[1][k] = Math.max(d[2][k-1]+s[1][k], d[2][k-2]+s[1][k]);
				d[2][k] = Math.max(d[1][k-1]+s[2][k], d[1][k-2]+s[2][k]);
			}
			
			System.out.println(Math.max(d[1][n], d[2][n]));
		}
	}
}