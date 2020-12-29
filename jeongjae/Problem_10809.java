package problem;

import java.util.Scanner;

public class Problem_10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] alpha_location = new int[26];
		
		for(int i=0; i<alpha_location.length; i++) alpha_location[i]=-1;
		String word = sc.nextLine();
		for(int i=0; i<word.length(); i++)
		{
			char alpha = word.charAt(i);
			if(alpha_location[alpha-'a']==-1) alpha_location[alpha-'a']=i;
		}
		for(int i : alpha_location) System.out.print(i+" ");
	}
}