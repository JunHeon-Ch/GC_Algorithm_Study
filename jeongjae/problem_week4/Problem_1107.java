package problem_week4;

//참고 블로그: https://geehye.github.io/baekjoon-1107/#
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Problem_1107 {
	
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = Math.abs(N-100);
		
		while(M>0)
		{
			list.add(sc.nextInt());
			M--;
		}
		
		for(int i=0; i<1000000; i++)
		{
			int len = check(i);
			if(len>0) min = Math.min(min, Math.abs(N-i)+len);
		}
		System.out.print(min);
	}
	
	public static int check(int n)
	{
		int len = 0;
		
		if(n==0) return list.contains(n)? 0:1;
		
		while(n>0)
		{
			if(list.contains(n%10)) return 0;
			len++;
			n/=10;
		}
		return len;
	}
}
