package problem_week5;

import java.util.Scanner;

public class Problem_15661 {
	
	public static int min = 810;
	public static int[] start_team;
	public static int[] link_team;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] S = new int[N+1][N+1];
		start_team = new int[N+1];
		link_team = new int[N+1];
		
		for(int i=1; i<N+1; i++)
		{
			for(int j=1; j<N+1; j++) S[i][j]=sc.nextInt();
		}
		
		go(1, 1, N, S);
		System.out.print(min);
	}
	
	public static void go(int index, int start, int N, int[][] S)
	{	
		
		if(start>N) return;
		
		int temp = 0;
		
		for(int i=1; i<=N; i++)
		{	
			boolean flag = false;
			
			for(int j=1; j<index; j++)
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
		
		for(int i=1; i<index; i++)
		{
			for(int j=i+1; j<index; j++)
			{
				start_sum += S[start_team[i]][start_team[j]];
				start_sum += S[start_team[j]][start_team[i]];
			}
		}
		
		for(int i=0; i<temp; i++)
		{
			for(int j=i+1; j<temp; j++)
			{
				link_sum += S[link_team[i]][link_team[j]];
				link_sum += S[link_team[j]][link_team[i]];
			}
		}
		
		if(Math.abs(start_sum-link_sum)<min)
		{
			min = Math.abs(start_sum-link_sum);
		}
		
		
		for(int i=start; i<=N; i++)
		{
			start_team[index]=i;
			go(index+1, i+1, N, S);
		}
	}
}