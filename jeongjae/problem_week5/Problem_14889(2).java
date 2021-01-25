package problem_week5;

import java.util.Scanner;

public class Problem_14889 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		
		int[] start = new int[N];
		int[] link = new int[N];
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++) arr[i][j] = sc.nextInt();
		}
		
		for(int i=1; i<1<<N; i++)
		{
			int[] var = new int[N];
			int count = 0;
			int bit = i;
			
			for(int j=0; bit!=0; j++, bit>>=1)
			{
				if((1&bit)==0) continue;
				var[j]=1;
			}
			
			for(int k=0; k<N; k++)
			{
				if(var[k]==1) count++;
			}
			
			if(count==N/2)
			{
				int start_sum = 0, link_sum = 0;
				int start_count = 0, link_count = 0;
				
				for(int k=0; k<N; k++)
				{
					if(var[k]==1) start[start_count++] = k;
					else link[link_count++]=k;
				}
				
				for(int x=0; x<N/2; x++)
				{
					for(int y=0; y<N/2; y++)
					{
						start_sum+=arr[start[x]][start[y]];
						link_sum+=arr[link[x]][link[y]];
					}
				}
				
				if(Math.abs(start_sum-link_sum)<min) min = Math.abs(start_sum-link_sum);
			}
		}
		System.out.print(min);
	}
}
