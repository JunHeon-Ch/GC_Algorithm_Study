package 프로그래머스.level2.소수_찾기;

import java.util.*;

class Solution {

    boolean[] visit;
    boolean[] prime;
    char[] num;
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int n = numbers.length();
        int max = (int) Math.pow(10, n);
        prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        findPrime(max);

        visit = new boolean[n];
        num = new char[n];
        solve(numbers.toCharArray(), 0, n);

        int answer = 0;
        for(int p : set) {
            if(prime[p]) answer++;
        }
        return answer;
    }

    private void solve(char[] numbers, int index, int n) {
        if(index != 0) {
            int res = Integer.parseInt(String.valueOf(num).substring(0, index));
            set.add(res);
        }
        if(index >= n) return;

        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            num[index] = numbers[i];
            solve(numbers, index + 1, n);
            visit[i] = false;
        }
    }

    private void findPrime(int max) {
        prime[0] = prime[1] = false;

        for(int i = 2; i <= Math.sqrt(max); i++) {
            if(prime[i]) {
                for(int j = 2 * i; j <= max; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}