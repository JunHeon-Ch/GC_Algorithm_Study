package problem_week3;

import java.util.Scanner;

public class Problem_1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cost[][] = new int[N+1][4];
		for(int i=1; i<=N; i++)
		{
			for(int j=1; j<=3; j++)
			{
				cost[i][j]=sc.nextInt();
			}
		}
		int d[][] = new int[N+1][4];
		d[1][1] = cost[1][1];
		d[1][2] = cost[1][2];
		d[1][3] = cost[1][3];
		for(int i=2 ;i<=N ; i++)
		{
			for(int j=1; j<=3; j++)
			{	
				
				if(j==1)
				{	
					d[i][j] = d[i-1][2];
					if(d[i-1][2]>d[i-1][3]) d[i][j] = d[i-1][3];
				}
				else if(j==2)
				{
					d[i][j]=d[i-1][1];
					if(d[i-1][1]>d[i-1][3]) d[i][j] = d[i-1][3];
					
				}
				else
				{
					d[i][j]=d[i-1][1];
					if(d[i-1][1]>d[i-1][2]) d[i][j] = d[i-1][2];
				}
				d[i][j] += cost[i][j];
			}
		}
		int min = d[N][1];
		for(int i=2; i<=3; i++)
		{
			if(d[N][i]<min) min = d[N][i];
		}
		System.out.print(min);
	}
}