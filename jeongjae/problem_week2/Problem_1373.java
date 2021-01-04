package problem_week2;

import java.util.Scanner;

public class Problem_1373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String binary = sc.nextLine();
		int len = binary.length();
		if(len%3==1) System.out.print(binary.charAt(0));
		else if(len%3==2) System.out.print((binary.charAt(0)-'0')*2+(binary.charAt(1)-'0'));
		for(int i=len%3; i<len; i=i+3)
		{
			System.out.print((binary.charAt(i)-'0')*4+(binary.charAt(i+1)-'0')*2+(binary.charAt(i+2)-'0'));
		}
		System.out.println();
	}
}