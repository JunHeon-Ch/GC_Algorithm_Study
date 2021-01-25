package problem_week5;

import java.util.Scanner;

public class Problem_14889 {
	
	public static int min = 810;
	public static int[] start_team;
	public static int[] link_team;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] S = new int[N][N];
		start_team = new int[N/2];
		link_team = new int[N/2];
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++) S[i][j]=sc.nextInt();
		}
		
		go(0, 0, N, S);
		System.out.print(min);
	}
	
	public static void go(int index, int start, int N, int[][] S)
	{
		if(index==N/2)
		{	
			int temp = 0;
			
			for(int i=0; i<N; i++)
			{	
				boolean flag = false;
				
				for(int j=0; j<N/2; j++)
				{
					if(start_team[j]==i) flag = true;
				}
				
				if(!flag)
				{
					link_team[temp] = i;
					temp++;
				}
			}
			
			int start_sum = 0, link_sum = 0;
			
			for(int i=0; i<N/2; i++)
			{
					for(int j=i+1; j<N/2; j++)
					{
						start_sum += S[start_team[i]][start_team[j]];
						start_sum += S[start_team[j]][start_team[i]];
						link_sum += S[link_team[i]][link_team[j]];
						link_sum += S[link_team[j]][link_team[i]];
					}
			}
			
			if(Math.abs(start_sum-link_sum)<min) min = Math.abs(start_sum-link_sum);
			return;
		}
		
		for(int i=start; i<N; i++)
		{
			start_team[index]=i;
			go(index+1, i+1, N, S);
		}
	}
}