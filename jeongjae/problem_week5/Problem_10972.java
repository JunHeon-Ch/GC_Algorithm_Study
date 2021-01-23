package problem_week5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_10972 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] permu = new int[N];
		int max=0, min=0, temp=0;
		boolean last = true;
		
		for(int i=0; i<N; i++) permu[i]=sc.nextInt();
		
		for(int i=0; i<N-1; i++)
		{
			if(permu[i]-1!=permu[i+1]) last = false;
		}
		
		for(int i=1; i<N; i++)
		{
			if(permu[i-1]<permu[i])  max = i-1;
		}
		
		for(int i=max+1; i<N; i++)
		{
			if(permu[i]>permu[max])
			{
				min = i;
			}
		}
		
		temp = permu[max];
		permu[max] = permu[min];
		permu[min] = temp;
		Arrays.sort(permu, max+1, permu.length);
		
		if(last) System.out.print(-1);
		else
		{
			for(int i=0; i<N; i++) System.out.print(permu[i]+" ");
		}
	}
}