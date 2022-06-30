package PS_2022.Programmers.level2.타겟_넘버;

/*
https://programmers.co.kr/learn/courses/30/lessons/43165
 * 알고리즘: 완전탐색
 * 시간복잡도: O(n^2), n=20(numbers 길이)
 */

class Solution {

    int n, target;
    int[] num;
    int ans = 0;

    public void solve(int[] numbers, int index) {
        if(index == n) {
            int res = 0;
            for(int i = 0; i < n; i++) res += num[i];
            if(target == res) ans++;
            return;
        }
        num[index] = numbers[index] * -1;
        solve(numbers, index + 1);
        num[index] = numbers[index];
        solve(numbers, index + 1);
    }

    public int solution(int[] numbers, int target) {
        this.n = numbers.length;
        this.target = target;
        num = new int[n];

        solve(numbers, 0);
        return ans;
    }
}