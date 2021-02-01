package problem_week6;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_14226 {
	// TODO Auto-generated method stub
    
    public static int[][] check;
    public static Queue<Point> q;
    public static int ans = -1;

    public static void main(String[] args) throws IOException {
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        check = new int[1001][1001];
        
        for (int[] i : check) Arrays.fill(i, -1);
        q = new LinkedList<>();

        check[1][0] = 0;
        q.offer(new Point(1, 0));
        while(!q.isEmpty())
        {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            
            if(check[x][x]==-1)
            {
                check[x][x] = check[x][y] + 1;
                q.offer(new Point(x, x));
            }
            
            if(x+y<=N&&check[x+y][y]==-1)
            {
                check[x+y][y]=check[x][y]+1;
                q.offer(new Point(x+y, y));
            }
            
            if(x-1>=0&&check[x-1][y]==-1)
            {
                check[x-1][y]=check[x][y]+1;
                q.offer(new Point(x-1, y));
            }

        }
        
        for(int i=0; i<=N; i++)
        {
            if(check[N][i]!=-1) if (ans==-1||ans>check[N][i]) ans = check[N][i];
        }
        System.out.print(ans);
    }
}