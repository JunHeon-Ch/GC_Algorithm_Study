package problem_week5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_10974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		nextPermutation(N, sb);
	}
	
	public static void nextPermutation(int N, StringBuilder sb)
	{
		int factorial = 1;
		for(int i=2; i<=N; i++) factorial*=i;
		
		int[] n = new int[N];
		for(int i=0; i<N; i++)
		{
			n[i]=i+1;
			sb.append(n[i]+" ");
		}
		sb.append("\n");
		
		for(int i=0; i<factorial-1; i++)
		{
			int max1 = 0, max2 = 0, temp = 0;
			for(int j=0; j<N-1; j++)
			{
				if(n[j]<n[j+1]) max1=j;
			}
			
			for(int j=max1+1; j<N; j++)
			{
				if(n[j]>n[max1]) max2=j; 
			}
			
			temp=n[max1];
			n[max1]=n[max2];
			n[max2]=temp;
			Arrays.sort(n, max1+1, n.length);
			
			for(int j=0; j<N; j++) sb.append(n[j]+" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}