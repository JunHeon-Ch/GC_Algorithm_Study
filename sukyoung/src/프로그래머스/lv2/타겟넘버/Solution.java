class Solution {
    public static int[] ans;
    public static int sum, cnt;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        sum = 0;
        cnt = 0;
        ans = new int[numbers.length];
        answer = dfs(numbers, target, 0);
        
        return answer;
    }
    public static int dfs(int[] numbers, int target, int depth){
        int sum = 0;
        int length = numbers.length;
        int[] inst = {0, 1};
    
        if(depth == numbers.length){
            for(int i=0; i<length; i++){
                if(ans[i] == 0){
                    sum += numbers[i];
                }
                else{
                    sum -= numbers[i];
                }
            }
             if(sum == target){
                cnt++;
            }
            
            return cnt;
        }
        
        for(int i=0; i<2; i++){
            ans[depth] = inst[i];
            dfs(numbers, target, depth+1);
        }
        
        return cnt;
    }
}