package problem_week4;

import java.util.Scanner;

public class Problem_17404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cost[][] = new int[N+1][4];
		int d[][] = new int[N+1][4];
		
		for(int i=1; i<=N; i++)
		{
			for(int j=1; j<=3; j++)
			{
				cost[i][j]=sc.nextInt();
			}
		}
		
		int ini = 1000*N+1;
		int min = 1000001;
		
		for(int i=1; i<4; i++)
		{
			for(int j=1; j<4; j++)
			{
				if(j==i) d[1][j] = cost[1][j];
				else d[1][j]=ini;
			}
			
			for(int j=2; j<=N; j++)
			{
				d[j][1] = Math.min(d[j-1][2], d[j-1][3])+cost[j][1];
				d[j][2] = Math.min(d[j-1][1], d[j-1][3])+cost[j][2];
				d[j][3] = Math.min(d[j-1][1], d[j-1][2])+cost[j][3];
			}
			
			for(int j=1; j<4; j++) if(j!=i) min = Math.min(min, d[N][j]);
		}
		System.out.print(min);
	}
}