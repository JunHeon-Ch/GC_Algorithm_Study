package problem;

import java.util.Scanner;

public class Problem_10808 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] alpha_count = new int[26];
		
		String word = sc.nextLine();
		for(int i=0; i<word.length(); i++) alpha_count[(int)word.charAt(i)-97]+=1;
		for(int i=0; i<alpha_count.length; i++)
		{
			sb.append(alpha_count[i]+" ");
		}
		System.out.print(sb);
	}
}
