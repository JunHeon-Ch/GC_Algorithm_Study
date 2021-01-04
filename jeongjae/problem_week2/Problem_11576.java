package problem_week2;

import java.util.Scanner;

public class Problem_11576 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int decimal = 0;
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int m = sc.nextInt();
		for(int i=m-1; i>=0; i--)
		{	
			int num = sc.nextInt();
			int pow = (int)Math.pow(A, i);
			decimal += num*pow;
		}
		while(decimal!=0)
		{
			sb.append(decimal%B);
			decimal = decimal/B;
		}
		char[] SB = sb.reverse().toString().toCharArray();
		for(int i=0; i<SB.length; i++)
		{	
			if(i==SB.length-1) System.out.print(SB[i]);
			else System.out.print(SB[i]+" ");
		}
	}
}