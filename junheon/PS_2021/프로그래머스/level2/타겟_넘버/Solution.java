package PS_2021.프로그래머스.level2.타겟_넘버;

class Solution {

    static int ans = 0;

    public int solution(int[] numbers, int target) {
        solve(numbers, target, 0, 0);
        return ans;
    }

    private void solve(int[] numbers, int target, int index, int res) {
        if(index == numbers.length) {
            if(target == res) ans++;
            return;
        }
        solve(numbers, target, index + 1, res - numbers[index]);
        solve(numbers, target, index + 1, res + numbers[index]);
    }
}