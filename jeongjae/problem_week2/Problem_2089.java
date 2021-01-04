package problem_week2;

import java.util.Scanner;

public class Problem_2089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int decimal = sc.nextInt();
		if(decimal==0) System.out.print(0);
		else
		{
			while(decimal!=1)
			{
				sb.append(Math.abs(decimal%-2));
				decimal=(int)(Math.ceil((double)decimal/(-2)));
			}
			sb.append(decimal);
			sb = sb.reverse();
			System.out.print(sb);
		}
	}
}