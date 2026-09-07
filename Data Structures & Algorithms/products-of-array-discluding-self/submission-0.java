class Solution {
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int zeroCount = 0;
        int[] answer = new int[nums.length];

        for(int i : nums){
            if(i == 0){
                zeroCount++;
            } else{
                sum *= i;
            }
        }

        if(zeroCount >= 2){
            return answer;
        }

        for(int i = 0; i < nums.length; i++){
            if(zeroCount == 1){
                if(nums[i] == 0){
                    answer[i] = sum;
                }
            } else{
                answer[i] = sum / nums[i];
            }
        }
        return answer;
    }
}  