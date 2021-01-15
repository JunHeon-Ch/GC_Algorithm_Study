package problem_week4;

import java.util.Scanner;

public class Problem_11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max = 0;
		
		int A = sc.nextInt();
		int[] a = new int[A+1];
		
		for(int i=1; i<A+1; i++) a[i]=sc.nextInt();
		
		int[] d = new int[A+1];
		d[1]=1;
		
		for(int i=1; i<A+1; i++)
		{	
			max = 0;
			for(int j=1; j<i; j++)
			{	
				if(a[j]>a[i]&&d[j]>max) max=d[j];
			}
			d[i]=max+1;
		}
		
		max=0;
		for(int i=1; i<A+1; i++)
		{
			if(d[i]>max) max = d[i];
		}
		System.out.print(max);
	}
}