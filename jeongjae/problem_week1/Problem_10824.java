package problem;

import java.util.Scanner;

public class Problem_10824 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long[] num = new long[4];
		for(int i=0; i<4; i++) num[i]=sc.nextInt();
		String str1 = Long.toString(num[0])+Long.toString(num[1]);
		String str2 = Long.toString(num[2])+Long.toString(num[3]);
		System.out.print(Long.parseLong(str1)+Long.parseLong(str2));
	}
}