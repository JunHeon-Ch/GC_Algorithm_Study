package problem_week4;

import java.util.Scanner;

public class Problem_1748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		double N = sc.nextDouble();
		int count = 1;
		int total = 0;
		int ten_pow = 10;
		
		for(int i=1; i<=N; i++)
		{
			if(i==ten_pow)
			{
				count=count+1;
				ten_pow=ten_pow*10;
			}
			total=total+count;
		}
		System.out.print(total);
	}
}