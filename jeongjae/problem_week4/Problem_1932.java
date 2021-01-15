package problem_week4;

import java.util.Scanner;

public class Problem_1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] num = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<i+1; j++) num[i][j]=sc.nextInt();
		}
		
		int[][] d = new int[n+1][n+1];
		d[1][1] = num[1][1];
		d[2][1] = d[1][1]+num[2][1];
		d[2][2] = d[1][1]+num[2][2];
		
		for(int i=3; i<n+1; i++)
		{
			for(int j=1; j<i+1; j++)
			{
				if(j==1) d[i][j] = d[i-1][j]+num[i][j];
				else if(j==i) d[i][j] = d[i-1][j-1]+ num[i][j];
				else d[i][j]=Math.max(d[i-1][j-1], d[i-1][j])+num[i][j];
			}
		}
		
		int max=0;
		for(int i=1; i<n+1; i++)
		{
			if(d[n][i]>max) max = d[n][i];
		}
		System.out.print(max);
	}
}