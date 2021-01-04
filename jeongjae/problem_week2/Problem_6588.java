package problem_week2;

import java.util.Scanner;

public class Problem_6588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] isNotPrime = new int[1000001];
		
		isNotPrime = eratosthenes(1000000);
		while(true)
		{
			boolean right = false;
			int num = sc.nextInt();
			if(num==0) break;
			for(int i=2; i<=num/2; i++)
			{
				if(isNotPrime[i]==0&&isNotPrime[num-i]==0)
				{
					right = true;
					System.out.println(num+" = "+i+" + "+(num-i));
					break;
				}
			}
			if(right==false) System.out.println("Goldbach's conjecture is wrong.");
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