package problem_week4;

import java.util.Scanner;

public class Problem_11054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max1 = 0;
		int max2 = 0;
		
		int N = sc.nextInt();
		int[] inc = new int[N+1];
		int[] dec = new int[N+1];
		
		for(int i=1; i<N+1; i++)
		{
			inc[i]=sc.nextInt();
			dec[N+1-i]=inc[i];
		}
		
		int[] inc_d = new int[N+1];
		int[] dec_d = new int[N+1];
		
		inc_d[1] = 1;
		dec_d[1] = 1;
		for(int i=2; i<N+1; i++)
		{	
			max1 = 0;
			max2 = 0;
			for(int j=1; j<i; j++)
			{	
				if(inc[j]<inc[i]&&inc_d[j]>max1) max1=inc_d[j];
				if(dec[j]<dec[i]&&dec_d[j]>max2) max2=dec_d[j];
			}
			inc_d[i]=max1+1;
			dec_d[i]=max2+1;
		}
		
		max1=0;
		for(int i=1; i<N+1; i++)
		{
			if(inc_d[i]+dec_d[N+1-i]>max1) max1 = inc_d[i]+dec_d[N+1-i];
		}
		System.out.print(max1-1);
	}
}