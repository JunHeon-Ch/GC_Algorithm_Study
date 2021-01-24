package problem_week5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_10819 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) A[i]=sc.nextInt();
		Arrays.sort(A);
		nextPermutation(N, A);		
	}
	
	public static void nextPermutation(int N, int[] A)
	{
		int factorial = 1;
		for(int i=2; i<=N; i++) factorial*=i;
		
		int max = 0;
		for(int i=0; i<=N-2; i++)
		{
			max += Math.abs(A[i]-A[i+1]);
		}
		
		for(int i=0; i<factorial-1; i++)
		{
			int m1 = 0, m2 = 0, temp = 0, sum = 0;
			for(int j=0; j<N-1; j++)
			{
				if(A[j]<A[j+1]) m1=j;
			}
			
			for(int j=m1+1; j<N; j++)
			{
				if(A[j]>A[m1]) m2=j; 
			}
			
			temp=A[m1];
			A[m1]=A[m2];
			A[m2]=temp;
			Arrays.sort(A, m1+1, A.length);
			
			for(int j=0; j<=N-2; j++)
			{
				sum += Math.abs(A[j]-A[j+1]);
			}
			if(sum>max) max=sum;
		}
		System.out.print(max);
	}
}