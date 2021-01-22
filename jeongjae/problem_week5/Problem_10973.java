package problem_week5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_10973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] permu = new int[N];
		int max1=0, max2=0, temp=0;
		boolean first = true;
		
		for(int i=0; i<N; i++) permu[i]=sc.nextInt();
		
		for(int i=0; i<N-1; i++)
		{
			if(permu[i]+1!=permu[i+1]) first = false;
		}
		
		for(int i=1; i<N; i++)
		{
			if(permu[i-1]>permu[i])  max1 = i-1;
		}
		
		for(int i=max1+1; i<N; i++)
		{
			if(permu[i]<permu[max1])
			{
				max2 = i;
			}
		}
		
		temp = permu[max1];
		permu[max1] = permu[max2];
		permu[max2] = temp;
		Arrays.sort(permu, permu.length, permu.length);
		
		if(first) System.out.print(-1);
		else
		{
			for(int i=0; i<=max1; i++) System.out.print(permu[i]+" ");
			for(int i=permu.length-1; i>max1; i--) System.out.print(permu[i]+" ");
		}
	}
}