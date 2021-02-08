package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2290 {
	
	public static long s;
	public static String n;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		s = Long.parseLong(input[0]);
		n = input[1];
		
		for (int height=0; height<2*s+3; height++) {
			
			for (int i=0; i<n.length(); i++) {
				
				if (height==0) {
					
					if (n.charAt(i)=='0' || n.charAt(i)=='2' || n.charAt(i)=='3' || n.charAt(i)=='5' || n.charAt(i)=='6' ||
						n.charAt(i)=='7' || n.charAt(i)=='8' || n.charAt(i)=='9') {
						sb.append(" ");
						for (int j=0; j<s; j++) sb.append("-");
						sb.append(" ");
					}
					
					else {
						for (int j=0; j<s+2; j++) sb.append(" ");
					}
				}
				
				else if(height>=1 && height<=s) {
					
					if (n.charAt(i)=='0' || n.charAt(i)=='4' || n.charAt(i)=='8' || n.charAt(i)=='9') {
						sb.append("|");
						for (int j=0; j<s; j++) sb.append(" ");
						sb.append("|");
					}
					
					else if (n.charAt(i)=='1' || n.charAt(i)=='2' || n.charAt(i)=='3' || n.charAt(i)=='7') {
						for (int j=0; j<s+1; j++) sb.append(" ");
						sb.append("|");
					}
					
					else {
						sb.append("|");
						for (int j=0; j<s+1; j++) sb.append(" ");
					}
				}
				
				else if(height==s+1) {
					
					if (n.charAt(i)=='0' || n.charAt(i)=='1' || n.charAt(i)=='7') {
						for (int j=0; j<s+2; j++) sb.append(" ");
					}
					
					else {
						sb.append(" ");
						for (int j=0; j<s; j++) sb.append("-");
						sb.append(" ");
					}
				}
				
				else if(height>=s+2 && height<=2*s+1) {
					
					if (n.charAt(i)=='0' || n.charAt(i)=='6' || n.charAt(i)=='8') {
						sb.append("|");
						for (int j=0; j<s; j++) sb.append(" ");
						sb.append("|");
					}
					
					else if (n.charAt(i)=='1' || n.charAt(i)=='3' || n.charAt(i)=='4' || n.charAt(i)=='5'
							|| n.charAt(i)=='7' || n.charAt(i)=='9'){
						for (int j=0; j<s+1; j++) sb.append(" ");
						sb.append("|");
					}
					
					else {
						sb.append("|");
						for (int j=0; j<s+1; j++) sb.append(" ");
					}
				}
				
				else {
					
					if(n.charAt(i)=='1' || n.charAt(i)=='4' || n.charAt(i)=='7') {
						for (int j=0; j<s+2; j++) sb.append(" ");
					}
					
					else {
						sb.append(" ");
						for (int j=0; j<s; j++) sb.append("-");
						sb.append(" ");
					}
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}