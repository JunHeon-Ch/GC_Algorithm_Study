package problem_week2;

import java.util.Scanner;

public class Problem_1212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String octal = sc.nextLine();
		for(int i=0; i<octal.length(); i++)
		{
			int num = octal.charAt(i)-'0';
			if(i==0)
			{
				if(num==0)
				{
					System.out.println(0);
					break;
				}
				if(num==1) sb.append("1");
				else if(num==2) sb.append("10");
				else if(num==3) sb.append("11");
				else if(num==4) sb.append("100");
				else if(num==5) sb.append("101");
				else if(num==6) sb.append("110");
				else if(num==7) sb.append("111");
			}
			else
			{
				if(num==0) sb.append("000");
				else if(num==1) sb.append("001");
				else if(num==2) sb.append("010");
				else if(num==3) sb.append("011");
				else if(num==4) sb.append("100");
				else if(num==5) sb.append("101");
				else if(num==6) sb.append("110");
				else if(num==7) sb.append("111");
			}
		}
		System.out.print(sb);
	}
}