package problem_week4;

import java.util.Scanner;

public class Problem_11055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max = 0;
		
		int N = sc.nextInt();
		
		int[] A = new int[N+1];
		for(int i=1; i<N+1; i++) A[i] = sc.nextInt();
		
		int[] d = new int[N+1];
		d[1]=A[1];
		
		for(int i=2; i<N+1; i++)
		{	
			max=0;
			for(int j=1; j<i; j++)
			{
				if(A[j]<A[i]&&max<d[j]) max=d[j];
			}
			d[i]=max+A[i];
		}
		
		max=0;
		for(int i=1; i<N+1; i++)
		{
			if(d[i]>max) max=d[i];
		}
		System.out.print(max);
	}
}