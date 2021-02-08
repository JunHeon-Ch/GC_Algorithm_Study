package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16935 {
	
	//d_N(divide N by 2), d_M(divide M by 2) for operations 5 and 6
	public static int N, M, n, m, R, d_N, d_M, min, max;
	public static int[][] A, temp;
	//clock_wise rotation(angle : 90)
	public static int[] c_w_x = { 0, 1, 0, -1 };
	public static int[] c_w_y = { -1, 0, 1, 0 };
	//counter_clock_wise rotation(angle : 90)
	public static int[] cc_w_x = { 1, 0, -1, 0 };
	public static int[] cc_w_y = { 0, 1, 0, -1 };


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		max = Math.max(N, M);
		A = new int[max][max];
		temp = new int[max][max];
		d_N = N/2;
		d_M = M/2;
		min = (Math.min(N, M))/2;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			switch (Integer.parseInt(st.nextToken())) {
				case 1:
					reverse(true);
					break;
				case 2:
					reverse(false);
					break;
				case 3:
					rotation(true);
					break;
				case 4:
					rotation(false);
					break;
				case 5:
					clock(c_w_x, c_w_y);
					break;
				case 6:
					clock(cc_w_x, cc_w_y);
					break;
				default:
					break;
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) System.out.print(A[i][j]+" ");
			System.out.println();
		}
	}
	
	//calculating n & m for operations 3, 4
	// 오른쪽으로 90도 회전, 왼쪽으로 90도 회전 연산을 위하여 n,m을 계산하기
	public static void calculate_nm(boolean flag) {
		
		if (flag) {
			if (n >= M) {
				n = 0;
				m--;
			}
		} else {
			if (n < 0) {
				n = M - 1;
				m++;
			}
		}
	}
	
	//copying 2D array temp to A after each operation
	//각 연산 수행후 A를 변경된 값으로 수정하기
	public static void copy() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = temp[i][j];
			}
		}
	}
	
	//operation 1,2
	// 상하반전연산, 좌우반전연산
	public static void reverse(boolean flag) {
		
		if (flag) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = A[N-1-i][j];
				}
			}
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = A[i][M-1-j];
				}
			}

		}
		copy();
	}
	
	//operation 3,4
	// 오른쪽으로 90도 회전, 왼쪽으로 90도 회전
	public static void rotation(boolean flag) {
		
		if (flag) {
			n = 0;
			m = N - 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					calculate_nm(flag);
					temp[n++][m] = A[i][j];
				}
			}
		} else {
			n = M - 1;
			m = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					calculate_nm(flag);
					temp[n--][m] = A[i][j];
				}
			}
		}
		
		int temp1 = N;
		int temp2 = d_N;
		N = M;
		d_N = d_M;
		M = temp1;
		d_M = temp2;
		copy();
	}
	
	//operation 5,6
	//시계방향회전, 반시계방향회전
	public static void clock(int[] x, int[] y) {
		
		for (int i = 0; i < d_N; i++) {
			for (int j = 0; j < d_M; j++) {
				temp[i][j] = A[i+x[1]*d_N][j+y[1]*d_M];
			}
		}
		for (int i = 0; i < d_N; i++) {
			for (int j = d_M; j < M; j++) {
				temp[i][j] = A[i+x[0]*d_N][j+y[0]*d_M];
			}
		}
		for (int i = d_N; i < N; i++) {
			for (int j = d_M; j < M; j++) {
				temp[i][j] = A[i+x[3]*d_N][j+y[3]*d_M];
			}
		}
		for (int i = d_N; i < N; i++) {
			for (int j = 0; j < d_M; j++) {
				temp[i][j] = A[i+x[2]*d_N][j+y[2]*d_M];
			}
		}
		copy();
	}
}