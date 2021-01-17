package problem_week4;

import java.util.Scanner;
import java.util.Arrays;

public class Problem_2309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] height = new int[10];
		int sum = 0;
		boolean flag = false;
		
		for(int i=0; i<9; i++)
		{
			height[i]=sc.nextInt();
			sum+=height[i];
		}
		
		for(int i=0; i<9; i++)
		{
			if(flag==true) break;
			
			for(int j=0; j<9; j++)
			{
				if(i==j) continue;
				if(sum-height[i]-height[j]==100)
				{
					height[i]=height[j]=0;
					flag=true;
					break;
				}
			}
		}
		Arrays.sort(height);
		
		for(int i=0; i<10; i++)
		{
			if(height[i]!=0) System.out.println(height[i]);
		}
	}
}