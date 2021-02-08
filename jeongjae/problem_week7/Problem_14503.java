package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14503 {
   
   public static int N, M, dir;
   public static int[][] map;
   public static int[] loc = new int[2];
   public static int[] nx = {0, 0, -1, 1};
   public static int[] ny = {1, -1, 0, 0};
   public static int count = 0;
   
   public static void main(String[] args) throws IOException {
	   // TODO Auto-generated method stub
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       String[] input = br.readLine().split(" ");
       N = Integer.parseInt(input[0]);
       M = Integer.parseInt(input[1]);
       map = new int[N][M];
       
       //storing the present location of the robot
       //로봇의 현재 위치 저장하기
       String[] line = br.readLine().split(" ");
       loc[0] = Integer.parseInt(line[0]);
       loc[1] = Integer.parseInt(line[1]);
       
       //storing the recent direction of the robot
       //로봇의 현재 방향 저장하기
       int dir = Integer.parseInt(line[2]);
       
       for(int i=0; i<N; i++) {
    	   String[] temp = br.readLine().split(" ");
    	   for(int j=0; j<M; j++) map[i][j]=Integer.parseInt(temp[j]);
       }
      
       map[loc[0]][loc[1]]=-1;
       count+=1;
              
       clean(loc, dir);
       System.out.println(count);
   	}
   
	public static void clean(int[] loc, int dir) {
		
		int clean = 0; 
		
		while(true) {
			
			clean = 0;
			
			//finding area that can be cleaned
			//청소할 수 있는 영역 찾기
			for(int i=0; i<4; i++) {
				
				int dx = loc[1] + nx[i];
				int dy = loc[0] + ny[i];
				
				if(dx>=0 && dx<map[0].length && dy>=0 && dy< map.length) {
					if(map[dy][dx]==1 || map[dy][dx]==-1) clean++;
				}
			}
			
			if(clean==4) {
				
				if(dir-2<0) dir+=2;
				else dir-=2;
				
				switch(dir) {
				
				case 0:
					loc[0]-=1;
					break;
				case 1:
					loc[1]+=1;
					break;
				case 2:
					loc[0]+=1;
					break;
				case 3:
					loc[1]-=1;
					break;
				default:
					break;
				}
				
				if(dir-2<0) dir+=2;
				else dir-=2;
				
				if(map[loc[0]][loc[1]]==1) break;
			}
			//clean!=4
			else {
				 
				dir=(dir+3)%4;
				move_robot(loc, dir);
			 
				 if (map[loc[0]][loc[1]] == 0) {
					 map[loc[0]][loc[1]] = -1;
					 count++;
				 }
			 }
		}
	}
	
	public static void move_robot(int[] loc, int dir) {
		
		switch(dir) {

		 case 0:
			 if(map[loc[0]-1][loc[1]]!=-1 && map[loc[0]-1][loc[1]]!=1) loc[0]-=1;
			 break;
		 case 1:
			 if(map[loc[0]][loc[1]+1]!=-1 && map[loc[0]][loc[1]+1]!=1) loc[1]+=1;
			 break;
		 case 2:
			 if(map[loc[0]+1][loc[1]]!=-1 && map[loc[0]+1][loc[1]]!=1) loc[0]+=1;
			 break;
		 case 3:
			 if(map[loc[0]][loc[1]-1]!=-1 && map[loc[0]][loc[1]-1]!=1) loc[1]-=1;
			 break;
		 default:
			 break;
		 }
	}
}