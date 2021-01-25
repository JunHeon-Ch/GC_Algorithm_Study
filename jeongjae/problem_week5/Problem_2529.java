package problem_week5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_2529 {
	
	public static int[] ans;
	public static boolean[] chosen;
	public static long max = 0;
	public static long min = 9876543210L;
	public static StringBuilder sb1, sb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		char[] inequality = new char[k];
		ans = new int[k+1];
		chosen = new boolean[10];
		
		for(int i=0; i<k; i++) inequality[i]=sc.next().charAt(0);
		
		go(0, k, inequality);
		System.out.println(sb2);
		System.out.print(sb1);
	}
	
	public static void go(int index, int k, char[] inequality)
	{
		if(index==k+1)
		{	
			boolean flag = true;
			
			for(int i=0; i<k; i++)
			{
				if(inequality[i]=='>')
				{
					if(ans[i]<ans[i+1]) flag = false;
				}
				else
				{
					if(ans[i]>ans[i+1]) flag = false;
				}
			}
			if(flag)
			{	
				if(Long.parseLong(Arrays.toString(ans).replaceAll("[^0-9]",""))<min)
				{
					min = Long.parseLong(Arrays.toString(ans).replaceAll("[^0-9]",""));
					sb1 = new StringBuilder();
					sb1.append(Arrays.toString(ans).replaceAll("[^0-9]",""));
					
				}
				if(Long.parseLong(Arrays.toString(ans).replaceAll("[^0-9]",""))>max)
				{
					max = Long.parseLong(Arrays.toString(ans).replaceAll("[^0-9]",""));
					sb2 = new StringBuilder();
					sb2.append(Arrays.toString(ans).replaceAll("[^0-9]",""));
				}
			}
			return;
		}
		
		for(int i=0; i<10; i++)
		{
			if(chosen[i]) continue;
			ans[index]=i;
			chosen[i]=true;
			go(index+1, k, inequality);
			chosen[i]=false;
		}
	}
}
