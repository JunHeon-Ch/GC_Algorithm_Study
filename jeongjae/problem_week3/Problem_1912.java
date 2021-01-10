package problem_week3;

import java.util.Scanner;

public class Problem_1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] seq = new int[n+1];
		int[] d = new int[n+1];
		for(int i=1; i<=n; i++) seq[i]=sc.nextInt();
		d[1]=seq[1];
		for(int i=2; i<=n; i++)
		{
			if(d[i-1]+seq[i]>seq[i]) d[i]=d[i-1]+seq[i];
			else d[i] = seq[i];
		}
		int max = d[1];
		for(int i=1; i<=n; i++)
		{
			if(d[i]>max) max=d[i];
		}
		System.out.print(max);
	}
}