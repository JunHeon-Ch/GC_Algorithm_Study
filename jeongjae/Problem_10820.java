package problem;

import java.util.Scanner;

public class Problem_10820 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str;
		
		while(sc.hasNextLine())
		{
			str=sc.nextLine();
			int[] comp = new int[4];
			for(int i=0; i<str.length(); i++)
			{
				
				if(str.charAt(i)>='a'&&str.charAt(i)<='z') comp[0]+=1;
				else if(str.charAt(i)>='A'&&str.charAt(i)<='Z') comp[1]+=1;
				else if(str.charAt(i)>='0'&&str.charAt(i)<='9') comp[2]+=1;
				else if(str.charAt(i)==' ') comp[3]+=1;
			}
			for(int i: comp) System.out.print(i+" ");
			System.out.println();
		}
	}
}