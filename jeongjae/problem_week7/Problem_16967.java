package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_16967 {
	
	public static int H, W, X, Y;
	public static int BH, BW;
	public static int[][] A, B;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		H = Integer.parseInt(input[0]);
		W = Integer.parseInt(input[1]);
		X = Integer.parseInt(input[2]);
		Y = Integer.parseInt(input[3]);
		BH = H+X;
		BW = W+Y;
		A = new int[H][W];
		B = new int[BH][BW];
		
		for (int i=0; i<BH; i++) {
			String[] line = br.readLine().split(" ");
			for (int j=0; j<BW; j++) B[i][j]= Integer.parseInt(line[j]);
		}
		
		for (int i=0; i<BH; i++) {
			for(int j=0; j<BW; j++) {
				
				if((i<X && j<W) || (j<Y && i<H)) A[i][j] = B[i][j];
				
				//(i, j)가 두 배열 모두에 포함되면
				else if(i>=X && j>=Y && i<H && j<W) A[i][j] = B[i][j]-A[i-X][j-Y];
			}
		}
		
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) System.out.print(A[i][j]+" ");
			System.out.println();
		}
	}
}