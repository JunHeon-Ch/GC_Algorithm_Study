package problem_week5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_1759 {
	
	public static char[] pw;
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int C = sc.nextInt();
		pw = new char[L];
		sb = new StringBuilder();
		char[] alpha = new char[C];
		
		for(int i=0; i<C; i++) alpha[i]=sc.next().charAt(0);
		Arrays.sort(alpha);
		
		go(0, 0, L, C, alpha);
		System.out.print(sb);
	}
	
	public static void go(int index, int start, int L, int C, char[] alpha)
	{
		int vowel = vowel_count(index, pw);
		
		if(index==L&&vowel>=1&&index-vowel>=2)
		{	
			for(int i=0; i<index; i++) sb.append(pw[i]);
			sb.append('\n');
			return;
		}
		if(index==L) return;
		
		for(int i=start; i<C; i++)
		{
			pw[index]=alpha[i];
			go(index+1, i+1, L, C, alpha);
		}
	}
	
	public static int vowel_count(int index, char[] alpha)
	{
		int count = 0;
		
		for(int i=0; i<index; i++)
		{
			if(alpha[i]=='a'||alpha[i]=='e'||alpha[i]=='i'||alpha[i]=='o'||alpha[i]=='u') count++;
		}
		return count;
	}
}
