package problem_week2;

import java.util.Scanner;

public class Problem_11005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		int N = sc.nextInt();
		int B = sc.nextInt();
		while(true)
		{
			if(N==0) break;
			sb.append(number[N%B]);
			N = N/B;
		}
		sb = sb.reverse();
		System.out.print(sb);
	}
}
