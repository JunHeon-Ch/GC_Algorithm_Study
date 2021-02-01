package problem_week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_16929_Baekjoon {
  static int n, m;
  static char[][] a;
  static boolean[][] visited;
  static int[][] count;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
    
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  String[] s = br.readLine().split(" ");
	  n = Integer.parseInt(s[0]);
	  m = Integer.parseInt(s[1]);
	  a = new char[n][m];
	  count = new int[n][m];
	  visited = new boolean[n][m];

	  for (int i = 0; i < n; i++) {
		  char[] c = br.readLine().toCharArray();
		  for (int j = 0; j < m; j++) {
			  a[i][j] = c[j];
		  }
	  }

	  for (int i = 0; i < n; i++) {
		  for (int j = 0; j < m; j++) {
			  if (traversal(i, j, a[i][j], 1)) {
				  System.out.println("Yes");
				  return;
			  }
		  }
	  }
	  System.out.println("No");
  	}

  	static boolean traversal(int x, int y, int color, int length) {
	
  		if(visited[x][y]) return length - count[x][y] >= 4;
  		visited[x][y] = true;
  		count[x][y] = length;
  		for (int i = 0; i < 4; i++) {
  			int nx = x + dx[i];
  			int ny = y + dy[i];
  			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
  				if (a[nx][ny] == color) {
  					if (traversal(nx, ny, color, length + 1)) {
  						return true;
  					}
  				}
  			}
  		}
  		return false;
  	}
}