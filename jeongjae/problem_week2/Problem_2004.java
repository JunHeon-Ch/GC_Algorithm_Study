package problem_week2;

import java.util.Scanner;

public class Problem_2004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		long m = sc.nextLong();
		long five = power_of_n(5,n)-power_of_n(5,n-m)-power_of_n(5,m);
		long two = power_of_n(2,n)-power_of_n(2,n-m)-power_of_n(2,m);
		if(five<=two) System.out.print(five);
		else System.out.print(two);
	}
	
	public static long power_of_n(long n, long num)
	{
		int count=0;
		while(num>=n)
		{
			count+=num/n;
			num/=n;
		}
		return count;
	}
}