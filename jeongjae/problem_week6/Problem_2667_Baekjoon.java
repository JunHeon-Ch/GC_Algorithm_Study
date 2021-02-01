package problem_week6;

import java.awt.Point;
import java.util.*;
 
public class Problem_2667_Baekjoon {
    
	static Queue<Point> q = new LinkedList<>();
    static int[][]map; 
    static int[][]visited;
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    static ArrayList al = new ArrayList();
    static int N;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int call_num = 0;
        N = scan.nextInt();    
        
        map = new int[N][N];
        visited = new int[N][N];
        String temp;
        
        for(int i=0;i<N;i++) {
            temp = scan.next();
            for(int j=0;j<N;j++) 
                map[i][j] = temp.charAt(j)-'0'; 
        }
 
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++) 
                if(map[i][j] == 1 && visited[i][j] == 0) {
                    BFS(i,j);
                    call_num++;
                }
        
        System.out.println(call_num);
        
        Collections.sort(al);
        for(int i=0;i<al.size();i++)
            System.out.println(al.get(i));
    }
    
    static void BFS(int i, int j) 
    {
        int nx,ny;
        int local_cnt = 1;
        q.offer(new Point(i,j));
        visited[i][j] = 1;
        
        while(q.isEmpty()==false) 
        {
            Point now;
            now = q.poll();
            
            for(int h=0;h<4;h++) {
            nx = now.x+dx[h];
            ny = now.y+dy[h];
            
            if(nx>=0&&ny>=0&&nx<N&&ny<N) {
            if(map[nx][ny] == 1 && visited[nx][ny]==0) {
                q.offer(new Point(nx,ny));
                visited[nx][ny] = 1;
                local_cnt++;
                    }
                }
            }
        }
        al.add(local_cnt);
    }
}
