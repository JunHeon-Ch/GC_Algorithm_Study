package problem_week2;

import java.util.Scanner;

public class Problem_1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean [] print = new boolean[N+1];
		print = eratosthenes(N);
		for(int i=M; i<=N; i++)
		{
			if(print[i]==false) System.out.println(i);
		}
	}
	public static boolean[] eratosthenes(int num)
	{	
		boolean[] isNotPrime = new boolean[num+1];
		
		isNotPrime[0]=true;
		isNotPrime[1]=true;
		for(int i=2; i*i<=num; i++)
		{	
			if(isNotPrime[i]) continue;
			for(int j=2*i; j<=num; j=j+i) isNotPrime[j]=true;
		}
		return isNotPrime;
	}
}