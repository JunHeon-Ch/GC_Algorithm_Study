package problem_week2;

import java.util.Scanner;

public class Problem_2745 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String number = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int sum=0;
		
		String N = sc.next();
		int B = sc.nextInt();
		sb.append(N);
		sb = sb.reverse();
		N = sb.toString();
		for(int i=0; i<N.length(); i++)
		{
			sum+=number.indexOf(N.charAt(i))*Math.pow(B,i);
		}
		System.out.print(sum);
	}
}