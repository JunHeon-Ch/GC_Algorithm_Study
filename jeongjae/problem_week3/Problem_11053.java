package problem_week3;

import java.util.Scanner;

public class Problem_11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max = 0;
		
		int N = sc.nextInt();
		int[] A = new int[N+1];
		int[] d = new int[N+1];
		/*
		 * 'd[i]: a[i]를 마지막으로 하는 가장 긴 증가하는 부분수열의 길이' 유추해내기 쉽지 않음.
		 */
		for(int i=1; i<=N; i++)
		{	
			A[i]=sc.nextInt();
			d[i]=1;
		}
		for(int i=2; i<=N; i++)
		{	
			max = 0;
			for(int j=1; j<i; j++)
			{
				if(A[j]<A[i]&&d[j]>max) max=d[j];
			}
			d[i]=max+1;
		}
		for(int i=1; i<=N; i++)
		{
			if(d[i]>max) max=d[i];
		}
		System.out.print(max);
	}
}