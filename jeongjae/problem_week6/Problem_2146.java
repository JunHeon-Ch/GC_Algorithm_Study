package problem_week6;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2146 {
    
	public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws IOException {
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] input = new int[n][n];
        int[][] dist = new int[n][n];
        int[][] group = new int[n][n];
        
        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) input[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(input[i][j] == 1 && group[i][j] == 0)
                {
                    Queue<Point> q = new LinkedList<Point>();
                    
                    group[i][j] = ++count;
                    q.add(new Point(i, j));
                    
                    while(!q.isEmpty())
                    {
                        Point p = q.remove();
                        int x = p.x, y = p.y;
                        
                        for(int k = 0; k < 4; k++)
                        {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            
                            if(0 <= nx && nx < n && 0 <= ny && ny < n)
                            {
                                if(input[nx][ny] == 1 && group[nx][ny] == 0)
                                {
                                    q.add(new Point(nx, ny));
                                    group[nx][ny] = count;
                                }
                            }
                        }
                    }
                }
            }
        }

        Queue<Point> q = new LinkedList<Point>();
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                dist[i][j] = -1;
                if(input[i][j] == 1)
                {
                    q.add(new Point(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty())
        {
            Point p = q.remove();
            int x = p.x, y = p.y;
            
            for(int k = 0; k < 4; k++)
            {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if(0 <= nx && nx < n && 0 <= ny && ny < n)
                {
                    if(dist[nx][ny] == -1)
                    {
                        dist[nx][ny] = dist[x][y] + 1;
                        group[nx][ny] = group[x][y];
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < 4; k++)
                {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    
                    if(0 <= x && x < n && 0 <= y && y < n)
                    {
                        if(group[i][j] != group[x][y]) ans = Math.min(ans, dist[i][j] + dist[x][y]);
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
}