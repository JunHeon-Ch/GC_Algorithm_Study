package problem;

import java.util.Scanner;
import java.util.Arrays;

public class Problem_11656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] Str = new String[str.length()];
		for(int i=0; i<str.length(); i++) Str[i] = str.substring(i, str.length());
		Arrays.sort(Str);
		for(String i: Str) System.out.println(i);
	}
}