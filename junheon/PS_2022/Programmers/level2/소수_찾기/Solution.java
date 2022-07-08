package PS_2022.Programmers.level2.소수_찾기;

import java.util.*;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 알고리즘: 완전탐색, 수학
 * 시간복잡도: O(nloglogn), n=10,000,000(10^(numbers 길이))
 */
class Solution {

    boolean[] notPrime, visit;
    char[] num, nums;
    int n;
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        n = numbers.length();
        int max = (int) Math.pow(10, n);
        notPrime = new boolean[max];
        findPrime(max);

        num = new char[n];
        visit = new boolean[n];
        nums = numbers.toCharArray();
        solve(0);

        int ans = 0;
        for(int i : set) {
            if(!notPrime[i]) ans++;
        }
        return ans;
    }

    // 시간복잡도: O(n^n), n=7(numbers의 길이)
    private void solve(int index) {
        if(index != 0) {
            int res = Integer.parseInt(String.valueOf(num, 0, index));
            set.add(res);
        }
        if(index >= n) return;

        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            num[index] = nums[i];
            solve(index + 1);
            visit[i] = false;
        }
    }

    // 시간복잡도: O(nloglogn), n=10,000,000(10^(numbers 길이))
    private void findPrime(int n) {
        notPrime[0] = notPrime[1] = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(!notPrime[i]) {
                for(int j = 2 * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }
}