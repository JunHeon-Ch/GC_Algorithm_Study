package problem_week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_1991 {	 	
	
	public static Map<String, List<String>> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		 
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("\\s");
			List<String> list = new ArrayList<>();
			list.add(tmp[1]);
			list.add(tmp[2]);
			map.put(tmp[0], list);
		}
		
		preorder("A");
		System.out.println(); 
		inorder("A");
		System.out.println(); 
		postorder("A"); 
	}
	
	public static void preorder(String v)
	{
		if(v.equals(".")) return;
		System.out.print(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
	}

	public static void inorder(String v)
	{
		if(v.equals(".")) return;
		inorder(map.get(v).get(0));
		System.out.print(v);
		inorder(map.get(v).get(1));
	}

	public static void postorder(String v)
	{
		if(v.equals(".")) return;
		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		System.out.print(v);
	}
}