package problem_week2;

import java.util.Scanner;
import java.lang.Math;

public class Problem_1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		for(int i=0; i<N; i++)
		{
			int num = sc.nextInt();
			if(isPrime(num)) count++;
		}
		System.out.print(count);
	}
	
	public static boolean isPrime(int num)
	{
		int divisor = 0;
		if(num==1) return false;
		else if(num==2||num==3) return true;
		for(int i=2; i<=Math.sqrt(num); i++)
		{
			if(num%i==0) divisor++;
		}
		if(divisor!=0) return false;
		else return true;
	}
}
