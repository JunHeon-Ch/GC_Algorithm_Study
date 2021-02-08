package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//¸øÇ°!
//unsolved!
public class Problem_20327 {
	
	public static int N, R;
	public static int size;
	public static int[][] A;
	public static int[] k, l;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		R = Integer.parseInt(input[1]);
		size = (int)Math.pow(2, N);
		A = new int[size][size];
		k = new int[R];
		l = new int[R];
		
		for (int i=0; i<size; i++) {
			input = br.readLine().split(" ");
			for (int j=0; j<size; j++) A[i][j] = Integer.parseInt(input[j]);
		}
		
		for (int i=0; i<R; i++) {
			input = br.readLine().split(" ");
			k[i]=Integer.parseInt(input[0]);
			l[i]=Integer.parseInt(input[1]);
		}
	}
}