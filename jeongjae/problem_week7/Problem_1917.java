package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//¸øÇ°!
//unsolved!
public class Problem_1917 {
	
	public static int[][] figure;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<3; i++) {
			figure = new int[6][6];
			for (int j=0; j<6; j++) {
				String[] line = br.readLine().split(" ");
				for (int k=0; k<6; k++) figure[j][k]=Integer.parseInt(line[k]);
			}
			if (isCube(figure)) System.out.println("yes");
			else System.out.println("no");
		}
	}
	
	public static boolean isCube(int[][] figure) {
		
		boolean hor = false;
		boolean ver = false;
		int starti = 0, startj = 0;
		
		for (int i=0; i<6; i++) {
			
			if (hor || ver) break;
			
			for (int j=0; j<6; j++) {
				
				if(j+3>=0 && j+3<6) {
					
					if(figure[i][j]==1 && figure[i][j+1]==1 && figure[i][j+2]==1 && figure[i][j+3]==1) {
						hor = true;
						starti = i;
						startj = j;
						break;
					}
				}
				
				if(i+3>=0 && i+3<6) {
					
					if(figure[i][j]==1 && figure[i+1][j]==1 && figure[i+2][j]==1 && figure[i+3][j]==1) {
						ver = true;
						starti = i;
						startj = j;
						break;
					}
				}
			}
		}
		
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		
		if (hor) {
			for (int i=startj; i<startj+4; i++) {
				if (starti-1>=0 && starti-1<6 && i>=0 && i<6) {					
					if (figure[starti-1][i]==1) up = true;
				}
			}
			
			for (int i=startj; i<startj+4; i++) {
				if (starti+1>=0 && starti+1<6 && i>=0 && i<6) {					
					if(figure[starti+1][i]==1) down = true;
				}
			}
		}
		
		else if(ver) {
			for (int i=starti; i<starti+4; i++) {
				if (startj-1>=0 && startj-1<6 && i>=0 && i<6) {					
					if (figure[i][startj-1]==1) left = true;
				}
			}
			
			for (int i=starti; i<starti+4; i++) {
				if (startj+1>=0 && startj+1<6 && i>=0 && i<6) {					
					if(figure[i][startj+1]==1) right = true;
				}
			}
		}
		
		if ((up && down) || (left && right)) return true;
		else return false;
	}
}