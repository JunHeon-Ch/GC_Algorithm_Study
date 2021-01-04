package problem_week2;

import java.util.Scanner;

public class Problem_1676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		while(N>=5)
		{
			count+=N/5;
			N/=5;
		}
		System.out.print(count);
	}
}
