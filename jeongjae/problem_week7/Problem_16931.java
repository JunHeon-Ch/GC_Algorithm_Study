package problem_week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem_16931 {
	
	public static int N, M, area = 0;
	public static int[][] cube;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		cube = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j=0; j<M; j++) cube[i][j] = Integer.parseInt(line[j]);
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				
				int count = cube[i][j]*4;
				
				for(int k=0; k<4; k++) {
					
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if (nx>=0 && nx<N && ny>=0 && ny<M) {
						
						if (cube[nx][ny]>cube[i][j]) {
							count-=cube[i][j];
						} 
						else {
							count-=cube[nx][ny];
						}
					}
				}
				area+=count;
			}
		}
		
		area+=2*N*M;
		System.out.println(area);
	}
}