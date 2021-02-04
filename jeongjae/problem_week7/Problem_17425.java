package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_17425 {
	
	public static final int MAX = 1000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		long[] f = new long[MAX+1];
		long[] g_N = new long[MAX+1];
		
		for(int i=0; i<MAX+1; i++) f[i]=1;
		
		for(int i=2; i<=MAX; i++) {
			for(int j=1; i*j<=MAX; j++) {
				f[i*j]+=i;
			}
		}
		
		for(int i=1; i<=MAX; i++) g_N[i]=g_N[i-1]+f[i];
		
		while(T>0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(g_N[N]+"\n");
			T--;
		}
		
		System.out.println(sb);
	}
}