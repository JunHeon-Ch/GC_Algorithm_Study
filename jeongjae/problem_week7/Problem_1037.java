package problem_week7;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int divisor = sc.nextInt();
		int[] real_divisor = new int[divisor];
		
		for(int i=0; i<divisor; i++) real_divisor[i]=sc.nextInt();
		
		Arrays.sort(real_divisor);
		System.out.print(real_divisor[0]*real_divisor[divisor-1]);
	}
}