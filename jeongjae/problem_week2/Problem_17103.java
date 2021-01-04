package problem_week2;

import java.util.Scanner;

public class Problem_17103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] isNotPrime = new int[10000001];
		
		isNotPrime = eratosthenes(1000000);
		int T = sc.nextInt();
		for(int i=0; i<T; i++)
		{
			int N = sc.nextInt();
			int partition = 0;
			for(int j=2; j<=N/2; j++)
			{
				if(isNotPrime[j]==0&&isNotPrime[N-j]==0) partition++;
			}
			System.out.println(partition);
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