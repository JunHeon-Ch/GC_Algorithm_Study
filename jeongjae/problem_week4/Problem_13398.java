package temp;

import java.util.Scanner;

public class Problem_13398 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max = 0;
		
		int n = sc.nextInt();
		
		int[] s = new int[n+1];
		for(int i=1; i<n+1; i++) s[i] = sc.nextInt();
		
		int[][] d = new int[n+1][2];
		d[1][0] = s[1];
		d[1][1] = s[1];
		
		for(int i=2; i<=n; i++)
		{	
			d[i][0] = Math.max(d[i-1][0]+s[i], s[i]);
			d[i][1] = Math.max(d[i-1][0], d[i-1][1]+s[i]);
		}
		
		for(int i=1; i<n+1; i++)
		{
			for(int j=0; j<2; j++)
			{
				if(d[i][j]>max) max = d[i][j];
			}
		}
		System.out.print(max);
	}
}