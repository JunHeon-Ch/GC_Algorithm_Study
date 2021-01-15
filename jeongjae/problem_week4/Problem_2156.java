package problem_week4;

import java.util.Scanner;

//푸는데 너무 오래걸림
//https://limkydev.tistory.com/112
public class Problem_2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//d[i] : i개의 포도주를 최대로 마신 양
		int[] d = new int[n+3];
		int[] g = new int[n+3];
		
		for(int i=1; i<=n; i++) g[i]=sc.nextInt();
		d[1]=g[1];
		d[2]=g[1]+g[2];
		
		for(int i=3; i<=n; i++)
		{
			d[i] = Math.max(Math.max(d[i-2] + g[i], d[i-3]+g[i-1]+g[i]), d[i-1]);
		}
		
		System.out.print(d[n]);
	}
}