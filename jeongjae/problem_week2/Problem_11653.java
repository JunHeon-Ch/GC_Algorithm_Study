package problem_week2;

import java.util.Scanner;

public class Problem_11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i=2;
		
		int N = sc.nextInt();
		while(N!=1)
		{
			if(N%i==0)
			{
				System.out.println(i);
				N=N/i;
			}
			else i=i+1;
		}
	}
}