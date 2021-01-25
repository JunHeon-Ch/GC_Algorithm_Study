package problem_week5;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_11723 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int M = Integer.parseInt(br.readLine());
		int bit = 0;
		
		while(M-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            int num;
            
            switch(operator)
            {
            	case "add" :
            		num = Integer.parseInt(st.nextToken());
            		bit |= (1 << (num - 1));
            		break;
            	
            	case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    bit = bit & ~(1 << (num - 1));
                    break;
                    
            	case "check" :
                    num = Integer.parseInt(st.nextToken());
                    sb.append((bit & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                    break;
               
            	case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    bit ^= (1 << (num - 1));
                    break;
                    
            	case "all" :
                    bit |= (~0);
                    break;
                    
                case "empty" :
                    bit &= 0;
                    break;
            }
            bw.write(sb.toString());
		}
	}
}