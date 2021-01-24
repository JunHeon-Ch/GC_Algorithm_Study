package problem_week5;

import java.util.Scanner;

public class Problem_6603 {
	
	public static int k;
	public static int[] S;
	public static int[] n;
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine())
		{
			k = sc.nextInt();
			if(k==0) return;
			S = new int[k];
			n = new int[k];
			sb = new StringBuilder();
			
			for(int i=0; i<k; i++) S[i]=sc.nextInt();
			go(0, 0, k, 6);
			System.out.print(sb+"\n");
			sb.delete(0, sb.length());
		}
	}
	
	public static void go(int index, int start, int k, int len)
	{
		if(index==len)
		{
			for(int i=0; i<len; i++) sb.append(n[i]+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<k; i++)
		{
			n[index]=S[i];
			go(index+1, i+1, k, len);
		}
	}
}
