package problem_week7;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_18290 {
	
	public static int N, M, K;
	public static int[][] num;
	public static boolean[][] check;
	public static Point[] comb;
	public static int max = -1000000;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		num = new int[N][M];
		check = new boolean[N][M];
		comb = new Point[K];
		
		for(int i=0; i<N; i++) {	
			String[] line = br.readLine().split(" ");
			for(int j=0; j<M; j++) num[i][j]=Integer.parseInt(line[j]);
		}
		
		go(0);
		System.out.println(max);
	}
	
	//길이가 K인 모든 조합 확인하기(만들어내기)
	//testing all combination
	public static void go(int index)
	{
		if(index==K) {
			//선택된 셀들이 서로 인접하지 않다면 이 셀들의 값을 합하여 최댓값과 비교한다.
			//if the chosen cells(total : K) are not adjacent to each other,
			// these cells are deserved to be tested to find out max value
			if(isNotAdjacent(comb)) {
				int sum = 0;
				for(int i=0; i<K; i++) {
					sum+=num[comb[i].x][comb[i].y];
				}
				if(sum>max) max = sum;
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!check[i][j]) {
					check[i][j]=true;
					comb[index]=new Point(i, j);
					go(index+1);
					check[i][j]=false;
				}
			}
		}
	}
	
	//선택된 셀들이 서로 인접한지 확인한다.
	//checking the chosen cells are adjacent to each other
	public static boolean isNotAdjacent(Point[] p)
	{
		for(int i=0; i<p.length; i++)
		{
			for(int j=i+1; j<p.length; j++)
			{
				if(p[i].x-1==p[j].x && p[i].y==p[j].y) return false;
				else if(p[i].x==p[j].x && p[i].y-1==p[j].y) return false;
				else if(p[i].x==p[j].x && p[i].y+1==p[j].y) return false;
				else if(p[i].x+1==p[j].x && p[i].y==p[j].y) return false;
			}
		}
		return true;
	}
}
