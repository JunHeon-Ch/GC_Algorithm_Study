package problem;

import java.util.Scanner;

public class Problem_11655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)>='a'&&str.charAt(i)<='z')
			{
				if(str.charAt(i)+13>'z') System.out.printf("%c", ('a'-1)+(str.charAt(i)+13)-'z');
				else System.out.printf("%c", str.charAt(i)+13);
			}
			else if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
			{
				if(str.charAt(i)+13>'Z') System.out.printf("%c", ('A'-1)+(str.charAt(i)+13)-'Z');
				else System.out.printf("%c", str.charAt(i)+13);
			}
			else System.out.printf("%c", str.charAt(i));
		}
	}
}