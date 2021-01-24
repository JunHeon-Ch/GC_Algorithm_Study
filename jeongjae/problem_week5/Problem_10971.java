package problem_week5;

import java.util.Scanner;
import java.util.Arrays;

public class Problem_10971 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] W = new int[N+1][N+1];
		int[] travel = new int[N+1];
		
		for(int i=1; i<N+1; i++)
		{
			for(int j=1; j<N+1; j++) W[i][j]=sc.nextInt();
		}
		
		for(int i=1; i<N+1; i++) travel[i]=i;
		
		minimumCost(N, W, travel);
	}
	
	public static void minimumCost(int N, int[][] W, int[] travel)
	{
		int factorial = 1, min = 0;
		
		for(int i=1; i<N; i++)
		{
			if(W[travel[i]][travel[i+1]]==0)
			{
				min=10000001;
				break;
			}
			min+=W[travel[i]][travel[i+1]];
		}
		if(W[travel[N]][travel[1]]==0) min = 10000001;
		else min+=W[travel[N]][travel[1]];
		
		for(int i=2; i<=N; i++) factorial*=i;
		
		for(int i=0; i<factorial-1; i++)
		{
			int max1 = 0, max2 = 0, temp = 0, sum = 0;
			for(int j=1; j<N; j++)
			{
				if(travel[j]<travel[j+1]) max1=j;
			}
			
			for(int j=max1+1; j<N+1; j++)
			{
				if(travel[j]>travel[max1]) max2=j; 
			}
			
			temp=travel[max1];
			travel[max1]=travel[max2];
			travel[max2]=temp;
			Arrays.sort(travel, max1+1, travel.length);
			
			for(int j=1; j<N; j++)
			{
				if(W[travel[j]][travel[j+1]]==0)
				{
					sum=10000001;
					break;
				}
				sum+=W[travel[j]][travel[j+1]];
			}
			if(W[travel[N]][travel[1]]==0) sum = 10000001;
			else sum+=W[travel[N]][travel[1]];
			
			if(sum<min) min = sum;
		}
		System.out.print(min);
	}
}
