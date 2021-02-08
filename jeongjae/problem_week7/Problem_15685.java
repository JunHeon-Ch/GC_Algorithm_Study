package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Problem_15685 {
	
	public static int N, x, y, d, g;
	public static boolean[][] check = new boolean[101][101];
	public static int count = 0;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
    	// TODO Auto-generated method stub
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
        
        for (int i=N; i>0; i--) {
        	
        	String[] input = br.readLine().split(" ");
        	x = Integer.parseInt(input[0]);
        	y = Integer.parseInt(input[1]);
        	d = Integer.parseInt(input[2]);
        	g = Integer.parseInt(input[3]);
        	
        	ArrayList<Integer> dir = new ArrayList<>();
        	dir.add(d);
            //storing direction information of each dragon curve with d and g 
        	//d, g를 가지고 존재하는 드래곤 커브 각각의 방향 정보 저장하기
        	while (g-->0) {
        		
        		for (int j=dir.size()-1; j>=0; j--) {
        			int temp = (dir.get(j)+1)%4;
        			dir.add(temp);
        		}
        	
        	//drawing each dragon curve with direction information of it
        	//각각의 드래곤 커브의 방향정보를 가지고 드래곤 커브 그리기
        	dragon_curve(x, y, dir);
        	}
        }
        
        //counting the number of square(1X1) whose edges are all part of dragon curve
        //크기가 1X1인 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 갯수
        for (int i=0; i<100; i++) {
        	for (int j=0; j<100; j++) {
        		if(check[i][j] && check[i][j+1] && check[i+1][j] && check[i+1][j+1]) count++;
        	}
        }
        System.out.print(count);
    }
    
    //그려진 곳은 check[x][y] = true
    public static void dragon_curve(int x, int y, ArrayList<Integer> dir) {
        
    	check[x][y] = true;
    	
        for (int d : dir) {
        	switch (d) {
        		//0: x좌표가 증가하는 방향
        		case 0:
                    check[++x][y]=true;
                    break;
                //1: y좌표가 감소하는 방향
                case 1:
                    check[x][--y]=true;
                    break;
                //2: x좌표가 감소하는 방향    
                case 2:
                    check[--x][y]=true;
                    break;
                //3: y좌표가 증가하는 방향    
                case 3:
                    check[x][++y]=true;
                    break;
                default:
                	break;
            }
        }
    }
}
