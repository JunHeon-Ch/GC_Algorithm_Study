package problem_week2;

import java.util.Scanner;

public class Problem_1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] print = new int[N+1];
		print = eratosthenes(N);
		for(int i=M; i<=N; i++)
		{
			if(print[i]==0) System.out.println(i);
		}
	}
	public static int[] eratosthenes(int num)
	{	
		int[] isNotPrime = new int[num+1];
		
		isNotPrime[0]=1;
		isNotPrime[1]=1;
		for(int i=2; i*i<=num; i++)
		{	
			if(isNotPrime[i]==1) continue;
			for(int j=i*i; j<=num; j=j+i) isNotPrime[j]=1;
		}
		return isNotPrime;
	}
}