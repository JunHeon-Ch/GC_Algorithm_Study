package problem_week7;

import java.util.Scanner;

public class Problem_4375 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {	
			long n = sc.nextLong();
			long num = 1;
			long extra = 0;
			long count = 0;
			long temp = 0;
			
			//n의 자리수 구하기
			while(n>=num) {	
				extra+=num;
				temp = num%n;
				num *=10;
				count++;
			}
			
			// (x*10)%n = ((x%n)*(10%n)%n)
			while(extra%n!=0) {
				temp = (temp*(10%n))%n;
				extra+=temp;
				count++;
			}
			
			System.out.println(count);
		}
	}
}