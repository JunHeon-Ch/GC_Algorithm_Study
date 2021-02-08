package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16926 {
	
	public static int N, M, R, C;
	public static int[][] A;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		//C : the number of cycles which have to be rotated for each operation
		//C : 연산이 한번 수행될때마다 회전해야 하는 사이클의 갯수
		//예를 들어 4x4에서는 c=2, 8x8에서는 c=3, 6x8에서는 c=3
		C = Math.min(N, M)/2;
		A = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			ccw_rotation(A);
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) System.out.print(A[i][j]+" ");
			System.out.println();
		}
	}
	
	//rotating 2D array A(counter clock wise)
	//존재하는 사이클(C) 각각에 대하여 반시계 회전 연산을 수행한다. 
	public static void ccw_rotation(int[][] A) {
		
		for (int i=0; i<C; i++) {
			
			int top = i;
            int bottom = N-1-i;
            int left = i;
            int right = M-1-i;
            int temp = A[i][i];
            
            for (int j=left; j<right; j++) A[top][j] = A[top][j+1];
            for (int j=top; j<bottom; j++) A[j][right] = A[j+1][right];
            for (int j=right; j>left; j--) A[bottom][j] = A[bottom][j-1];
            for (int j=bottom; j>top; j--) A[j][left] = A[j-1][left];
            A[top+1][left] = temp;
		}
	}
}